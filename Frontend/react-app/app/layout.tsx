import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
import ReactQueryClientProvider from "../components/ReactQueryClientProvider";

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "Plant Parent",
  description: "Horse kicks tree, farts on dogs then runs away.",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
  <ReactQueryClientProvider>
    <html lang="en">
      <body className={inter.className}>{children}</body>
    </html>
  </ReactQueryClientProvider>
  );
}
