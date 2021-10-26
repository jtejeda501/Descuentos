-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-10-2021 a las 16:35:52
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `descuentos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `to_cupones`
--

CREATE TABLE `to_cupones` (
  `id` bigint(20) NOT NULL,
  `fecha_caducidad` date NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_bin NOT NULL,
  `restaurante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `to_cupones`
--

INSERT INTO `to_cupones` (`id`, `fecha_caducidad`, `descripcion`, `restaurante`) VALUES
(1, '2021-11-20', 'aplica para el 20%', 1),
(2, '2021-11-26', 'aplica para un 50%', 2),
(3, '2021-09-15', 'aplica para el 15 en la compra de $200', 3),
(4, '2021-10-28', 'aplica con el 32% de descuento', 4),
(5, '2021-09-08', '10% de descuento', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `to_descuentos`
--

CREATE TABLE `to_descuentos` (
  `id` bigint(11) NOT NULL,
  `usuario_id` bigint(11) NOT NULL,
  `activo` varchar(10) COLLATE utf8_bin NOT NULL,
  `cupon_id` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `to_restaurantes`
--

CREATE TABLE `to_restaurantes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(80) COLLATE utf8_bin NOT NULL,
  `rfc` varchar(80) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `to_restaurantes`
--

INSERT INTO `to_restaurantes` (`id`, `nombre`, `rfc`) VALUES
(1, 'el gran tacazo', 'rfc12345'),
(2, 'el carboncito', 'rfc84756'),
(3, 'lalos', 'rfc67209'),
(4, 'sal y pimienta', 'rfc70912'),
(5, 'sushito', 'rfc9k02u');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `to_usuarios`
--

CREATE TABLE `to_usuarios` (
  `id` bigint(20) NOT NULL,
  `correo` varchar(80) COLLATE utf8_bin NOT NULL,
  `nombre` varchar(80) COLLATE utf8_bin NOT NULL,
  `psswrd` varchar(45) COLLATE utf8_bin NOT NULL,
  `referencia_usuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `to_usuarios`
--

INSERT INTO `to_usuarios` (`id`, `correo`, `nombre`, `psswrd`, `referencia_usuario`) VALUES
(1, 'cesarleon@gmail.com', 'cesar leon de diaz', '12345678', NULL),
(2, 'ardel@gmail.com', 'fernado ponce ardel', '12345678', 1),
(3, 'ever@gmail.com', 'lucas ever zuela', 'jshfy4756', NULL),
(4, 'valds@hotmail.com', 'jeronimo de valdez', 'jdsh84736', 3),
(5, 'loej@yahoo.com', 'Leonidas del campo marte', 'jd94ñ000', NULL),
(6, 'cesarAfd', 'cesar', '12345677', 2),
(7, 'artAgmail.com', 'ArturoGomez', 'ldjs9384', 1),
(8, 'gra@hotmail.com', 'Gerardo Matias', '12345dsg', 2),
(9, 'clau@hotmail.com', 'Claudia Ramirez', '12455dsg', NULL),
(10, 'claudio@hotmail.com', 'Claudio Perez', '12loiudsg', 7),
(11, 'porras@hotmail.com', 'Fernando Perez', '10ooiudsg', 7),
(12, 'erick@hotmail.com', 'Erick', '10oo63dsg', 9);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `to_cupones`
--
ALTER TABLE `to_cupones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurante` (`restaurante`);

--
-- Indices de la tabla `to_descuentos`
--
ALTER TABLE `to_descuentos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cupon` (`cupon_id`),
  ADD KEY `usuario` (`usuario_id`);

--
-- Indices de la tabla `to_restaurantes`
--
ALTER TABLE `to_restaurantes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `to_usuarios`
--
ALTER TABLE `to_usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `to_cupones`
--
ALTER TABLE `to_cupones`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `to_descuentos`
--
ALTER TABLE `to_descuentos`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `to_restaurantes`
--
ALTER TABLE `to_restaurantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `to_usuarios`
--
ALTER TABLE `to_usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `to_cupones`
--
ALTER TABLE `to_cupones`
  ADD CONSTRAINT `restaurante` FOREIGN KEY (`restaurante`) REFERENCES `to_restaurantes` (`id`);

--
-- Filtros para la tabla `to_descuentos`
--
ALTER TABLE `to_descuentos`
  ADD CONSTRAINT `cupon` FOREIGN KEY (`cupon_id`) REFERENCES `to_cupones` (`id`),
  ADD CONSTRAINT `usuario` FOREIGN KEY (`usuario_id`) REFERENCES `to_usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
