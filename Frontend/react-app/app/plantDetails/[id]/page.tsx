"use client";
import { useState, useEffect } from "react"
import Image from "next/image";
import Navbar from '../../../components/Navbar.tsx';

export default function plantDetails({ params }) {
    console.log(params)
    const [plant, setPlant] = useState({})
    const [loading, setLoading] = useState(false)
    useEffect(() => {
       setLoading(true)
        fetch(`http://localhost:5001/plant/details/${params?.id}`)
            .then(response => response.json())
            .then(data => {
                setLoading(false)
                setPlant(data)
            })
    },[])
  return (
    <main className="flex min-h-screen flex-col items-center p-12">
        <Navbar/>
        <div className='mt-8 w-full px-24'>
            <div key={plant?.plantId} className="bg-white p-4 mb-4 rounded-md text-black w-full flex">
                <div className="">
                    <img className="h-48" src={plant?.imgUrl}></img>
                </div>
                <div className="w-3/5 px-4 items-center flex-1 flex-col content-evenly">
                    <p><strong>Name: </strong>{plant?.plantName}</p>
                    <p><strong>Also known as: </strong>{plant?.scientificName}</p>
                    <p><strong>Planting cycle: </strong>{plant?.cycle}</p>
                    <p><strong>Watering frequency: </strong>{plant?.watering}</p>
                    <p><strong>Sunlight: </strong>{plant?.sunlight}</p>
                </div>
                <div className="w-1/5 px-4 items-end flex-1 flex-col content-evenly justify-between">
                    <div className="bg-emerald-800 w-32 rounded-lg text-white items-center justify-center">
                        <button className="p-1 self-center" onClick={ () => {addToCollection(plant)} }>Get plant details</button>
                    </div>
                </div>
            </div>
        </div>
    </main>
  );
}