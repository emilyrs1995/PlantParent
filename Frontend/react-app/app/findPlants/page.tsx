"use client";
import {useState} from "react"
import Image from "next/image";
import Navbar from '../../components/Navbar.tsx';

export default function FindPlants() {
    const [plantName, setPlantName] = useState("")
    const [plants, setPlants] = useState([])
    const [loading, setLoading] = useState(false)
    const handleChange = (event) => {
        const { name, value } = event.target;
        setPlantName(value)
    }
    const handleSubmit = async (event) => {
        event.preventDefault();
        await findPlants(plantName);
    };
    async function findPlants(plantName) {
        try {
            setLoading(true);
            const response = await fetch(`http://localhost:5001/plant/list/${plantName}`);
            const plants = await response.json();
            setPlants(plants);
            setLoading(false);
        } catch (error) {
            console.log(error);
            setLoading(false);
        }
    }
    const renderSearchResults = () => {
        return plants?.map((plant) => {
            return (
                <div key={plant?.plantId} className="bg-white p-4 mb-4 rounded-md text-black">
                    <img src={plant?.imgUrl}></img>
                    <p>{plant?.plantName}</p>
                    <div className="bg-emerald-800 rounded-lg text-white items-center justify-center">
                        <button className="p-1 self-center" onClick={ () => {addToCollection(plant)} }>Add to collection</button>
                    </div>
                </div>
            )
        })
    }
    const addToCollection = async (plant) => {
        try {
            const response = await fetch("http://localhost:5001/plant/collection", {
                  method: "POST",
                  headers: {
                    "Content-Type": "application/json",
                  },
                  body: JSON.stringify(plant),
                });
        } catch (error) {
            console.log(error);
        }
    }
  return (
    <main className="flex min-h-screen flex-col items-center p-24">
        <Navbar/>
        <div className='mt-8 flex-col'>
            <form onSubmit={handleSubmit} className='flex flex-col text-white items-center justify-center'>
              <label>Name of plant</label>
              <input
                className="mt-2 text-black p-1"
                type="text"
                id="search"
                name="search"
                onChange={handleChange}
                />
                <button type="submit" className="mt-2 bg-emerald-800 rounded-lg text-white items-center justify-center px-4 py-1">Search</button>
            </form>
        </div>
        <div className='mt-8'>
            { loading ? <p>Searching...</p> : renderSearchResults() }
        </div>
    </main>
  );
}