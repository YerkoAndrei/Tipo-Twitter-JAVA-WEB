-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-07-2015 a las 03:42:45
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `final`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE IF NOT EXISTS `comentarios` (
`id` int(11) NOT NULL,
  `texto` varchar(140) NOT NULL,
  `user` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`id`, `texto`, `user`) VALUES
(30, 'comentario de YERKO 1', 'yerkoandrei'),
(31, 'asdasd #trabajoPrgr2', 'yerkoandrei'),
(32, 'qweqweqweqwe #trabajoPrgr2', 'yerkoandrei'),
(37, 'otro #otro', 'yerkoandrei'),
(38, 'andres co #trabajoPrgr2', 'andres'),
(39, 'coment juan #otro', 'juan'),
(40, 'comen seg juan', 'juan'),
(65, 'asd @andres adaweqw', 'yerkoandrei'),
(66, 'asd @andres ajajajajh', 'yerkoandrei'),
(67, 'Esdfsdfsdf', 'yerkoandrei'),
(68, 'etiqueto a @yerkoandrei', 'andres'),
(69, 'otra vez a @yerkoandrei', 'andres'),
(70, 'yo mismo @juan', 'juan'),
(76, 'comen seg juan\r\n Tuit anterior de: juan', 'yerkoandrei'),
(77, 'otra vez a @yerkoandrei\r\n Tuit anterior de: andres', 'yerkoandrei'),
(78, 'etiqueto a @yerkoandrei\r\n Tuit anterior de: andres', 'yerkoandrei'),
(79, 'wewewewewe #trabajoPrgr2', 'yerkoandrei'),
(80, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'yerkoandrei'),
(81, 'comentario con todo #otro @andres', 'yerkoandrei');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguidores`
--

CREATE TABLE IF NOT EXISTS `seguidores` (
`id` int(11) NOT NULL,
  `user_seguidor` varchar(30) NOT NULL,
  `user_seguido` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `seguidores`
--

INSERT INTO `seguidores` (`id`, `user_seguidor`, `user_seguido`) VALUES
(19, 'andres', 'juan'),
(20, 'juan', 'andres'),
(17, 'yerkoandrei', 'andres'),
(18, 'yerkoandrei', 'juan');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `user` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`user`, `pass`, `nombre`) VALUES
('andres', '123', 'andres molina'),
('juan', '123', 'juan morales aranguiz'),
('yerkoandrei', '123', 'yerko orellana abello');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vinculohashtag`
--

CREATE TABLE IF NOT EXISTS `vinculohashtag` (
`id` int(11) NOT NULL,
  `id_comentario` int(11) NOT NULL,
  `hashtag` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vinculohashtag`
--

INSERT INTO `vinculohashtag` (`id`, `id_comentario`, `hashtag`) VALUES
(1, 31, 'trabajoPrgr2'),
(2, 32, 'trabajoPrgr2'),
(7, 37, 'otro'),
(8, 38, 'trabajoPrgr2'),
(9, 39, 'otro'),
(11, 79, 'trabajoPrgr2'),
(12, 81, 'otro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vinculouser`
--

CREATE TABLE IF NOT EXISTS `vinculouser` (
`id` int(11) NOT NULL,
  `id_comentario` int(11) NOT NULL,
  `user` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vinculouser`
--

INSERT INTO `vinculouser` (`id`, `id_comentario`, `user`) VALUES
(1, 66, 'andres'),
(2, 68, 'yerkoandrei'),
(3, 69, 'yerkoandrei'),
(4, 70, 'juan'),
(5, 77, 'yerkoandrei'),
(6, 78, 'yerkoandrei'),
(7, 81, 'andres');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
 ADD PRIMARY KEY (`id`), ADD KEY `user` (`user`);

--
-- Indices de la tabla `seguidores`
--
ALTER TABLE `seguidores`
 ADD PRIMARY KEY (`id`), ADD KEY `user_seguidor` (`user_seguidor`,`user_seguido`), ADD KEY `user_seguido` (`user_seguido`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`user`);

--
-- Indices de la tabla `vinculohashtag`
--
ALTER TABLE `vinculohashtag`
 ADD PRIMARY KEY (`id`), ADD KEY `id_comentario` (`id_comentario`);

--
-- Indices de la tabla `vinculouser`
--
ALTER TABLE `vinculouser`
 ADD PRIMARY KEY (`id`), ADD KEY `id_comentario` (`id_comentario`,`user`), ADD KEY `user` (`user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comentarios`
--
ALTER TABLE `comentarios`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=82;
--
-- AUTO_INCREMENT de la tabla `seguidores`
--
ALTER TABLE `seguidores`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT de la tabla `vinculohashtag`
--
ALTER TABLE `vinculohashtag`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `vinculouser`
--
ALTER TABLE `vinculouser`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentarios`
--
ALTER TABLE `comentarios`
ADD CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`user`) REFERENCES `usuario` (`user`);

--
-- Filtros para la tabla `seguidores`
--
ALTER TABLE `seguidores`
ADD CONSTRAINT `seguidores_ibfk_1` FOREIGN KEY (`user_seguidor`) REFERENCES `usuario` (`user`),
ADD CONSTRAINT `seguidores_ibfk_2` FOREIGN KEY (`user_seguido`) REFERENCES `usuario` (`user`);

--
-- Filtros para la tabla `vinculohashtag`
--
ALTER TABLE `vinculohashtag`
ADD CONSTRAINT `vinculohashtag_ibfk_1` FOREIGN KEY (`id_comentario`) REFERENCES `comentarios` (`id`);

--
-- Filtros para la tabla `vinculouser`
--
ALTER TABLE `vinculouser`
ADD CONSTRAINT `vinculouser_ibfk_1` FOREIGN KEY (`id_comentario`) REFERENCES `comentarios` (`id`),
ADD CONSTRAINT `vinculouser_ibfk_2` FOREIGN KEY (`user`) REFERENCES `usuario` (`user`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
