-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2017 at 12:59 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `islandhopping`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` varchar(255) NOT NULL,
  `adminName` varchar(255) NOT NULL,
  `adminAddress` text NOT NULL,
  `adminPhone` varchar(255) NOT NULL,
  `adminEmail` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `adminName`, `adminAddress`, `adminPhone`, `adminEmail`) VALUES
('00001', 'Zalika', 'UiTM Shah Alam', '0103536956', 'zalika@gmail.com'),
('00002', 'Muhammad Azri Hashim', 'Taiping, Perak', '0105856548', 'azri@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `boat`
--

CREATE TABLE `boat` (
  `boatID` int(11) NOT NULL,
  `boatSeries` varchar(255) NOT NULL,
  `boatTime` varchar(255) NOT NULL,
  `boatDate` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `boat`
--

INSERT INTO `boat` (`boatID`, `boatSeries`, `boatTime`, `boatDate`) VALUES
(13, 'KV1111', '8.00 AM', '16 July 2017'),
(14, 'KV2222', '9.00 AM', '16 July 2017'),
(15, 'KV3333', '10.00 AM', '16 July 2017'),
(16, 'KV4444', '11.00 AM', '16 July 2017'),
(17, 'KV5555', '12.00 PM', '16 July 2017'),
(18, 'KV1111', '1.00 PM', '16 July 2017'),
(19, 'KV2222', '2.00 PM', '16 July 2017'),
(20, 'KV3333', '3.00 PM', '16 July 2017'),
(21, 'KV4444', '8.00 AM', '17 July 2017'),
(22, 'KV5555', '9.00 AM', '17 July 2017'),
(23, 'KV1111', '10.00 AM', '17 July 2017'),
(24, 'KV2222', '12.00 PM', '17 July 2017'),
(25, 'KV1111', '2.00 PM', '17 July 2017');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `custID` varchar(255) NOT NULL,
  `custICNum` varchar(255) NOT NULL,
  `custName` varchar(255) NOT NULL,
  `custAddress` text NOT NULL,
  `custPhone` varchar(255) NOT NULL,
  `custEmail` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`custID`, `custICNum`, `custName`, `custAddress`, `custPhone`, `custEmail`) VALUES
('3FA630EB384765F0', '950917026405', 'Muhammad Azizi Saad', 'UiTM Shah Alam', '0103735036', 'muhamamdazizisaad95@gmail.com'),
('3FC2329798AE79A8', '950502046408', 'Nuradlina Najwa Musa', 'Bertam Perdana, Pulau Pinang', '0135652356', 'nur.0812@gmail.com'),
('3FE2517AFD5A4849', '9408', 'amir', 'seremban', '0108945034', 'aaa@gmail.com'),
('3FE33C62EC4938A2', 'xcvb', 'asdfghjk', 'aasdfg', 'asdf', 'asf'),
('3FE9FBBA72E369F3', '940507058695', 'Muhammad Nazirul Naim', 'UiTM Shah Alam', '0106589652', 'nazirulnaim@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `adminID` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`adminID`, `username`, `password`) VALUES
('00001', 'zalika@00001', 'zalika@00001'),
('00002', 'azri@00002', 'azri@00002');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `paymentID` int(11) NOT NULL,
  `reservationID` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentID`, `reservationID`, `total`) VALUES
(15, 15, 40),
(16, 16, 20),
(17, 17, 60),
(18, 18, 240),
(19, 19, 40);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `revID` int(11) NOT NULL,
  `revSeat` varchar(255) NOT NULL,
  `revDate` varchar(255) NOT NULL,
  `revTime` varchar(255) NOT NULL,
  `custID` varchar(255) NOT NULL,
  `boatID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`revID`, `revSeat`, `revDate`, `revTime`, `custID`, `boatID`) VALUES
(15, 'A1,B1', '16 July 2017', '8.00 AM', '3FA630EB384765F0', '13'),
(16, 'C1', '16 July 2017', '8.00 AM', '3FE2517AFD5A4849', '13'),
(17, 'A1,B1,C1', '17 July 2017', '9.00 AM', '3FC2329798AE79A8', '22'),
(18, 'A1,A2,B1,B2,C1,C2,D1,D2,E1,E2,F1,F2', '17 July 2017', '12.00 PM', '3FE9FBBA72E369F3', '24'),
(19, 'A2,B2', '17 July 2017', '9.00 AM', '3FE33C62EC4938A2', '22');

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `seatID` int(11) NOT NULL,
  `boatID` int(11) NOT NULL,
  `A1` int(11) NOT NULL,
  `A2` int(11) NOT NULL,
  `B1` int(11) NOT NULL,
  `B2` int(11) NOT NULL,
  `C1` int(11) NOT NULL,
  `C2` int(11) NOT NULL,
  `D1` int(11) NOT NULL,
  `D2` int(11) NOT NULL,
  `E1` int(11) NOT NULL,
  `E2` int(11) NOT NULL,
  `F1` int(11) NOT NULL,
  `F2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`seatID`, `boatID`, `A1`, `A2`, `B1`, `B2`, `C1`, `C2`, `D1`, `D2`, `E1`, `E2`, `F1`, `F2`) VALUES
(13, 13, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0),
(14, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(15, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(17, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(18, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(19, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(20, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(21, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(22, 22, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0),
(23, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(24, 24, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(25, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `boat`
--
ALTER TABLE `boat`
  ADD PRIMARY KEY (`boatID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`custID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`paymentID`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`revID`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`seatID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `boat`
--
ALTER TABLE `boat`
  MODIFY `boatID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `paymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `revID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `seatID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
