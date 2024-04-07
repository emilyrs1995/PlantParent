import Image from "next/image";
import Link from 'next/link'
import Navbar from '../components/Navbar.tsx'

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center p-12 bg-homepage bg-center">
        <Navbar/>
    </main>
  );
}
