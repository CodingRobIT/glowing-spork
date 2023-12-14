package de.kaharo.backend.doitkids;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class DoitKidsServiceTest {

    @Test
    public void testGetAllKidsActivity() {
        // Mock for KidsActivityRepoInterface created
        KidsActivityRepoInterface mockRepo = mock(KidsActivityRepoInterface.class);

        // Example data for the mock
        List<KidsActivity> mockActivities = Arrays.asList(
                new KidsActivity("141515", "Spielplatz", 4, false, true, 30, true, false, 0.0f, "Deutschland"),
                new KidsActivity("2342342", "Hallenbad 2", 2, true, null, null, null, null, 7.50f, "Unbekannt")
        );

        // Define mock behaviour
        when(mockRepo.findAll()).thenReturn(mockActivities);

        // Create DoitKidsService with the mock repository
        DoitKidsService doitKidsService = new DoitKidsService(mockRepo);

        // Call method
        List<KidsActivity> result = doitKidsService.getAllKidsActivity();

        // Check if the expected result was returned
        assertEquals(mockActivities, result);

        // Check if the findAll() method has been called
        verify(mockRepo, times(1)).findAll();
    }
}
