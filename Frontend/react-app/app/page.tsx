import Image from "next/image";
import Link from 'next/link'
import Navbar from '../components/Navbar.tsx'

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center p-12 bg-homepage bg-center">
        <Navbar/>
        <div class="text-sm absolute inset-x-2 bottom-0 h-8 ">Maintained by: Emily, Molly, Jeremy, and Caio</div>
    </main>
  );
}
