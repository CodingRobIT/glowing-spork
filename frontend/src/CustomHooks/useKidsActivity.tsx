import {KidsActivity} from "../models/KidsActivity";
import axios from "axios";
import {useState} from "react";

export default function useKidsActivity() {

    const [kidsActivity, setKidsActivity] = useState<KidsActivity[]>([])
    const [searchTerm] = useState('');
    const filteredKidsActivitys = kidsActivity.filter((kidsactivity) =>
    kidsactivity.name.toLowerCase().includes(searchTerm.toLowerCase()));

    const loadAllKidsActivity = async () => {
        axios.get("/api/kidsactivity")
            .then((getAllKidsActivityResponse) => {
            setKidsActivity(getAllKidsActivityResponse.data)
            })
            .catch((error) => {
                console.error(error)
            });
    }


    return {kidsActivity: filteredKidsActivitys, searchTerm, loadAllKidsActivity}
}