-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 25, 2020 at 04:54 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ims`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(10) UNSIGNED NOT NULL,
  `category` varchar(100) NOT NULL,
  `description` longtext,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `category`, `description`, `created_at`) VALUES
(1, 'fitness', NULL, '0000-00-00 00:00:00'),
(2, 'protein', NULL, '0000-00-00 00:00:00'),
(3, 'cloth', NULL, '0000-00-00 00:00:00'),
(4, 'ntg', NULL, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `description` text NOT NULL,
  `product_code` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `category_id` int(10) UNSIGNED NOT NULL,
  `manufacture_date` date DEFAULT NULL,
  `expire_date` date DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `size` varchar(100) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `brand_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `description`, `product_code`, `stock`, `category_id`, `manufacture_date`, `expire_date`, `amount`, `size`, `gender`, `weight`, `brand_name`) VALUES
(2, 'pull', '8', 'this is a pull', 89, 7, 1, '0002-11-30', '0002-11-30', 0, 'XS', 'male', 10, 'maked'),
(3, 'eat7', '75', 'this is a cloth', 42, 7, 3, '2020-01-01', '2019-10-15', 20, '', '', 0, 'maasimum'),
(4, 't-shirt', '400', 'hello', 42, 15, 3, '0002-11-30', '0002-11-30', 0, 'XS', 'male', 0, 'sonam'),
(5, 'jbn', '77', 'ds', 54, 22, 1, '0002-11-30', '0002-11-30', 0, 'XS', 'male', 2, 'iuhh'),
(6, 'vfdx', '685', 'sfdv', 43, 5, 1, '0002-11-30', '0002-11-30', 0, 'XS', 'male', 77, 'vdfs');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `address` varchar(255) NOT NULL,
  `mob_number` varchar(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` tinyint(1) DEFAULT '0',
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `address`, `mob_number`, `username`, `password`, `role`, `created_at`) VALUES
(1, 'Avinna', 'Shrestha', 'abin.crestha01@gmail.com', 'nepaltar', '9843709578', 'admin', 'admin', 0, '2019-12-18'),
(2, 'admin', 'admin', '', '', '8', '', 'd41d8cd98f00b204e9800998ecf8427e', 0, '2019-12-26'),
(3, 'Avinna', 'Shrestha', 'abin@gmail.com', 'nepaltar', '9843709578', 'test1', 'cd1b8ecf103743a98958211a11e33b71', 1, '2020-04-12'),
(4, 'Avinna', 'Shrestha', 'abin.crestha01@gmail.com', 'nepaltar', '9843709578', 'abinstha25', '5d41402abc4b2a76b9719d911017c592', 0, '2020-09-18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `category` (`category`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id_fk` (`category_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
