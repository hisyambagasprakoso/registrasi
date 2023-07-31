-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Jul 2023 pada 17.49
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cybertrend`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `telp` varchar(13) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`user_id`, `telp`, `email`, `nama`, `password`) VALUES
(1, '085345678769', 'hisyambagasprakoso@gmail.com', 'Hisyam Bagas Prakoso', '$2a$10$8knMxwMjCrj./.joYNceG.f.0.oA5w8GD1SOdWwyyy30IG4wM9mk2'),
(2, '085334567552', 'hisamprakoso@gmail.com', 'Hisyam Bagas Prakoso', '$2a$10$lW0DqgQNV93Iy3VBnw3Gs.mqrBLb.NPFITRqfLqF4v18dXBobg6Vq'),
(4, '081325727711', 'yuliernawati140763@gmail.com', 'Yuli ernawati', '$2a$10$1rMqZFBAhroGy7qU3EPCCeoO6O3lh4mDhN4CERNGAe2FO.k0NOGRO'),
(5, '817703110', 'santosoco@yahoo.com', 'Satrio', '$2a$10$y0/q4o0taqerS4t0iS6hNOerl/kTNfhSHjJfPvfGoPLRBjIIvWKuS'),
(8, '8767', 'irwan8susanto@gmail.com', 'test 2', '$2a$10$czcCRnQqNVsamnTQEOsIq.zSEpdxQf.sOtBJm9wfVRNJauATAQCce'),
(10, '085345678769', 'bagusbhakti23@gmail.com', 'Bagus Bhakti D', '$2a$10$OMgETTXl6gOGK0z.h2iljOncdpbScnyJAhqEpenbsfMM4MFfLIgBq');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
