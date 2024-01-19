-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-01-2024 a las 20:03:24
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `shiftmanager`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turn`
--

CREATE TABLE `turn` (
  `id` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `office` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `postalCode` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `province` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `turnDate` date DEFAULT NULL,
  `turnProcedure` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `turnState` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `userId` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `turn`
--

INSERT INTO `turn` (`id`, `description`, `office`, `postalCode`, `province`, `turnDate`, `turnProcedure`, `turnState`, `userId`) VALUES
('003-aa', 'sdasdadsadsasad', 'Office1 Alava', '55555', 'Alava', '2024-02-03', 'Police-fingerprint taking (card issuance), long-duration card renewal and duplication', 'on hold', 'X1234567P'),
('004-aa', 'dsadsad', 'Office1 Alava', '12345', 'Alava', '2024-01-19', 'Police-fingerprint taking (card issuance), long-duration card renewal and duplication', 'on hold', 'X1234567P'),
('005-aa', 'dsadsadadsada', 'Office4 Asturias', '12345', 'Asturias', '2024-01-19', 'Police-certificates (residence, non-residence and concordance)', 'on hold', 'X1234567X'),
('006-aa', 'Ejemplo de descripcion', 'Office3 Badajoz', '12345', 'Badajoz', '2024-01-21', 'Police-certificates (residence, non-residence and concordance)', 'on hold', 'X3123123P');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `gmail` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `phoneNumber` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `lastName` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `gmail`, `name`, `phoneNumber`, `lastName`) VALUES
('X1234567P', 'example2@gmail.com', 'name', '321321313', 'surname'),
('X1234567X', 'example@gmail.com', 'nameA', '123456789', 'surnameA'),
('X3123123P', 'example@gmail.com', 'Jose', '123123123', 'Garcia');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `turn`
--
ALTER TABLE `turn`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_turn_userId` (`userId`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turn`
--
ALTER TABLE `turn`
  ADD CONSTRAINT `FK_turn_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
