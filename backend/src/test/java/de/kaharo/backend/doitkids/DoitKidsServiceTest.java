package de.kaharo.backend.doitkids;

import de.kaharo.backend.doitComments.CommentList;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class DoitKidsServiceTest {


    @Mock
    private KidsActivityRepoInterface kidsActivityRepoInterface;

    @InjectMocks
    private DoitKidsService doitKidsService;

    @Test
    public void testGetAllKidsActivityWithoutComments() {
        // GIVEN Mock for KidsActivityRepoInterface created
        KidsActivityRepoInterface mockRepo = mock(KidsActivityRepoInterface.class);

        // Example data for the mock
        List<KidsActivity> mockActivities = Arrays.asList(
                new KidsActivity("141515", "Spielplatz", (byte) 4, false, true, (byte) 30, true, false, 0.0f, "Deutschland", null),
                new KidsActivity("2342342", "Hallenbad 2", (byte) 2, true, null, null, null, null, 7.50f, "Unbekannt", null)
        );

        // Define mock behaviour
        when(mockRepo.findAll()).thenReturn(mockActivities);

        // Create DoitKidsService with the mock repository
        DoitKidsService doitKidsService = new DoitKidsService(mockRepo);

        // WHEN  Call method
        List<KidsActivity> result = doitKidsService.getAllKidsActivity();

        // THEN
        // Check if the expected result was returned
        assertEquals(mockActivities, result);
        // Check if the findAll() method has been called
        verify(mockRepo, times(1)).findAll();
    }

    @DirtiesContext
    @Test
    public void testGetAllKidsActivityWithCommentList() {
        // GIVEN Mock for KidsActivityRepoInterface created
        KidsActivityRepoInterface mockRepo = mock(KidsActivityRepoInterface.class);

        // New here is also the CommentList record is also mocked here
        List<CommentList> comments = Arrays.asList(
                new CommentList("23233", "232323", "Benutzer1", LocalDateTime.now(), "Toller Spielplatz!", true),
                new CommentList("123131","123123123","Benutzer2", LocalDateTime.now().minusDays(1), "Sehr schön für Kinder.", false)
        );
        // Example data for the mock
        List<KidsActivity> mockActivities = Arrays.asList(
                new KidsActivity("141515", "Spielplatz", (byte) 4, false, true, (byte) 30, true, false, 0.0f, "Deutschland", comments),
                new KidsActivity("2342342", "Hallenbad 2", (byte) 2, true, null, null, null, null, 7.50f, "Unbekannt", null)
        );

        // Define mock behaviour
        when(mockRepo.findAll()).thenReturn(mockActivities);

        // Create DoitKidsService with the mock repository
        DoitKidsService doitKidsService = new DoitKidsService(mockRepo);

        // WHEN  Call method
        List<KidsActivity> result = doitKidsService.getAllKidsActivity();

        // THEN
        // Check if the expected result was returned
        assertEquals(mockActivities, result);
        // Check if the findAll() method has been called
        verify(mockRepo, times(1)).findAll();
    }

    @DirtiesContext
    @Test
    public void testGetAllKidsActivity_NoActivitiesFound() {
        // GIVEN
        KidsActivityRepoInterface mockRepo = mock(KidsActivityRepoInterface.class);
        // Return empty list for the mock repo
        when(mockRepo.findAll()).thenReturn(Collections.emptyList());
        DoitKidsService doitKidsService = new DoitKidsService(mockRepo);

        // When: getAllKidsActivity is called and no activities are found
        // Then: A NoSuchElementException is thrown with the expected message
        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                doitKidsService::getAllKidsActivity
        );

        // Check if the error message corresponds to the expected message
        assertEquals("No kids activities found", exception.getMessage());
    }

    @DirtiesContext
    @Test
    public void testGetAllKidsActivity_WithManyActivities() {
        // Given: A mock repository with a large number of KidsActivity objects
        KidsActivityRepoInterface mockRepo = mock(KidsActivityRepoInterface.class);
        List<KidsActivity> manyActivities = IntStream.range(0, 5000000)
                .mapToObj(i -> new KidsActivity(String.valueOf(i), "Aktivität " + i, (byte) 4, true, false, (byte) 20, false, true, 5.0f, "Ort " + i, null))
                .collect(Collectors.toList());
        when(mockRepo.findAll()).thenReturn(manyActivities);
        DoitKidsService doitKidsService = new DoitKidsService(mockRepo);

        // When: getAllKidsActivity is called
        List<KidsActivity> result = doitKidsService.getAllKidsActivity();

        // Then: A large list of activities is returned
        assertEquals(5000000, result.size());
        verify(mockRepo, times(1)).findAll();
    }

}
