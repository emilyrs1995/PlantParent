import Link from 'next/link'

export default function Navbar() {
  return (
      <div className="text-lg flex flex-row justify-between w-full">
          <Link href="/myPlants">My Plants</Link>
          <Link href="/">Home</Link>
          <Link href="/findPlants">Find Plants</Link>
      </div>
  );
}