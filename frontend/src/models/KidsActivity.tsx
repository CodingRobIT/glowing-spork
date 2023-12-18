// Definieren des Typs für einen einzelnen Kommentar
export type Comment = {
    user: string;
    commentDate: Date;
    comment: string;
    approved: boolean;
};

// Definieren des KidsActivity-Typs, einschließlich des Kommentartyps
export type KidsActivity = {
    id: string;
    name: string;
    minAge: number;
    indoor: boolean;
    outdoor: boolean;
    groupSize: number;
    sporty: boolean;
    educational: boolean;
    cost: number;
    location: string;
    comments: Comment[] | null; // Kommentare sind entweder eine Liste von Kommentaren oder null
};
