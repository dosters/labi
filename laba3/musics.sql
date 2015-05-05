-- phpMyAdmin SQL Dump
-- version 4.2.12
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Апр 14 2015 г., 01:01
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `musics`
--

-- --------------------------------------------------------

--
-- Структура таблицы `music`
--

CREATE TABLE IF NOT EXISTS `music` (
`id` int(11) NOT NULL,
  `likes` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `scr` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `music`
--

INSERT INTO `music` (`id`, `likes`, `name`, `scr`) VALUES
(18, 1, 'Lana Del Rey  - Young And Beautiful (Europa Plus).mp3', 'https://dl.dropboxusercontent.com/1/view/lm8snpfjrjmk9am/%D0%9F%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F/musicAppsss/Lana%20Del%20Rey%20%20-%20Young%20And%20Beautiful%20%28Europa%20Plus%29.mp3'),
(20, 0, 'Maroon 5 - Leaving California.mp3', 'https://dl.dropboxusercontent.com/1/view/u1moqxocc8zzvip/%D0%9F%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F/musicAppsss/Maroon%205%20-%20Leaving%20California.mp3'),
(21, 2, 'Maroon 5  - Animals.mp3', 'https://dl.dropboxusercontent.com/1/view/l8117erv25r0jxr/%D0%9F%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F/musicAppsss/Maroon%205%20%20-%20Animals.mp3'),
(22, 1, 'OneRepublic  -  Counting Stars.mp3', 'https://dl.dropboxusercontent.com/1/view/3i9eeve5e6hlwd1/%D0%9F%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F/musicAppsss/OneRepublic%20%20-%20%20Counting%20Stars.mp3'),
(23, 1, 'Eminem ft. Rihanna - The Monster.mp3', 'https://dl.dropboxusercontent.com/1/view/iva9xpj8vsq3fes/%D0%9F%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F/musicAppsss/Eminem%20ft.%20Rihanna%20-%20The%20Monster.mp3'),
(24, 0, '30 Seconds To Mars - Hurricane.mp3', 'https://dl.dropboxusercontent.com/1/view/bb1tmwwtqr300yc/%D0%9F%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F/musicAppsss/30%20Seconds%20To%20Mars%20-%20Hurricane.mp3');

-- --------------------------------------------------------

--
-- Структура таблицы `musiclikedperson`
--

CREATE TABLE IF NOT EXISTS `musiclikedperson` (
`id` int(11) NOT NULL,
  `idPerson` int(11) NOT NULL,
  `idMusic` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `musiclikedperson`
--

INSERT INTO `musiclikedperson` (`id`, `idPerson`, `idMusic`) VALUES
(78, 1, 18),
(72, 1, 21),
(73, 1, 22),
(74, 1, 23),
(76, 2, 21);

-- --------------------------------------------------------

--
-- Структура таблицы `person`
--

CREATE TABLE IF NOT EXISTS `person` (
`id` int(11) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `person`
--

INSERT INTO `person` (`id`, `lastname`, `name`) VALUES
(6, '', ''),
(1, '&#1044;&#1080;&#1084;', '&#1044;&#1080;&#1084;&#1072;'),
(2, '&#1044;&#1086;&#1089;&#1090;&#1072;', '&#1044;&#1080;&#1084;&#1072;'),
(7, '1995', 'admin'),
(3, 'asd', 'Dima'),
(5, 'dima', 'dima');

-- --------------------------------------------------------

--
-- Структура таблицы `personmusic`
--

CREATE TABLE IF NOT EXISTS `personmusic` (
`id` int(11) NOT NULL,
  `idMusic` int(11) NOT NULL,
  `idPerson` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `personmusic`
--

INSERT INTO `personmusic` (`id`, `idMusic`, `idPerson`) VALUES
(71, 18, 1),
(66, 18, 3),
(62, 21, 2),
(64, 22, 2),
(68, 22, 3),
(70, 24, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `personplaylist`
--

CREATE TABLE IF NOT EXISTS `personplaylist` (
`id` int(11) NOT NULL,
  `idPerson` int(11) NOT NULL,
  `idPlaylist` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `personplaylist`
--

INSERT INTO `personplaylist` (`id`, `idPerson`, `idPlaylist`) VALUES
(15, 1, 18),
(14, 2, 17),
(4, 3, 3),
(5, 5, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `playlist`
--

CREATE TABLE IF NOT EXISTS `playlist` (
`id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `likes` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `playlist`
--

INSERT INTO `playlist` (`id`, `name`, `likes`) VALUES
(3, 'Anna', 2),
(4, 'bsuir', 2),
(14, 'dima', 2),
(15, 'dima', 1),
(17, 'mys', 0),
(18, 't', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `playlistlikedperson`
--

CREATE TABLE IF NOT EXISTS `playlistlikedperson` (
`id` int(11) NOT NULL,
  `idPlaylist` int(11) NOT NULL,
  `idPerson` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `playlistlikedperson`
--

INSERT INTO `playlistlikedperson` (`id`, `idPlaylist`, `idPerson`) VALUES
(39, 3, 1),
(31, 4, 1),
(37, 4, 2),
(35, 15, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `playlistmusic`
--

CREATE TABLE IF NOT EXISTS `playlistmusic` (
`id` int(11) NOT NULL,
  `idMusic` int(11) NOT NULL,
  `idPlaylist` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `playlistmusic`
--

INSERT INTO `playlistmusic` (`id`, `idMusic`, `idPlaylist`) VALUES
(23, 22, 14);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `music`
--
ALTER TABLE `music`
 ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `musiclikedperson`
--
ALTER TABLE `musiclikedperson`
 ADD PRIMARY KEY (`id`), ADD KEY `idPerson` (`idPerson`,`idMusic`), ADD KEY `idPerson_2` (`idPerson`), ADD KEY `idMusic` (`idMusic`);

--
-- Индексы таблицы `person`
--
ALTER TABLE `person`
 ADD PRIMARY KEY (`id`), ADD KEY `lastname` (`lastname`,`name`);

--
-- Индексы таблицы `personmusic`
--
ALTER TABLE `personmusic`
 ADD PRIMARY KEY (`id`), ADD KEY `idMusic` (`idMusic`,`idPerson`), ADD KEY `idMusic_2` (`idMusic`), ADD KEY `idPerson` (`idPerson`);

--
-- Индексы таблицы `personplaylist`
--
ALTER TABLE `personplaylist`
 ADD PRIMARY KEY (`id`), ADD KEY `idPerson` (`idPerson`,`idPlaylist`), ADD KEY `idPerson_2` (`idPerson`), ADD KEY `idPlaylist` (`idPlaylist`);

--
-- Индексы таблицы `playlist`
--
ALTER TABLE `playlist`
 ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `playlistlikedperson`
--
ALTER TABLE `playlistlikedperson`
 ADD PRIMARY KEY (`id`), ADD KEY `idPlaylist` (`idPlaylist`,`idPerson`), ADD KEY `idPerson` (`idPerson`);

--
-- Индексы таблицы `playlistmusic`
--
ALTER TABLE `playlistmusic`
 ADD PRIMARY KEY (`id`), ADD KEY `idMusic` (`idMusic`,`idPlaylist`), ADD KEY `idPlaylist` (`idPlaylist`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `music`
--
ALTER TABLE `music`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT для таблицы `musiclikedperson`
--
ALTER TABLE `musiclikedperson`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=81;
--
-- AUTO_INCREMENT для таблицы `person`
--
ALTER TABLE `person`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT для таблицы `personmusic`
--
ALTER TABLE `personmusic`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=72;
--
-- AUTO_INCREMENT для таблицы `personplaylist`
--
ALTER TABLE `personplaylist`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT для таблицы `playlist`
--
ALTER TABLE `playlist`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT для таблицы `playlistlikedperson`
--
ALTER TABLE `playlistlikedperson`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT для таблицы `playlistmusic`
--
ALTER TABLE `playlistmusic`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `personmusic`
--
ALTER TABLE `personmusic`
ADD CONSTRAINT `personmusic_ibfk_1` FOREIGN KEY (`idMusic`) REFERENCES `music` (`id`),
ADD CONSTRAINT `personmusic_ibfk_2` FOREIGN KEY (`idPerson`) REFERENCES `person` (`id`);

--
-- Ограничения внешнего ключа таблицы `personplaylist`
--
ALTER TABLE `personplaylist`
ADD CONSTRAINT `personplaylist_ibfk_1` FOREIGN KEY (`idPerson`) REFERENCES `person` (`id`),
ADD CONSTRAINT `personplaylist_ibfk_2` FOREIGN KEY (`idPlaylist`) REFERENCES `playlist` (`id`);

--
-- Ограничения внешнего ключа таблицы `playlistlikedperson`
--
ALTER TABLE `playlistlikedperson`
ADD CONSTRAINT `playlistlikedperson_ibfk_1` FOREIGN KEY (`idPlaylist`) REFERENCES `playlist` (`id`),
ADD CONSTRAINT `playlistlikedperson_ibfk_2` FOREIGN KEY (`idPerson`) REFERENCES `person` (`id`);

--
-- Ограничения внешнего ключа таблицы `playlistmusic`
--
ALTER TABLE `playlistmusic`
ADD CONSTRAINT `playlistmusic_ibfk_1` FOREIGN KEY (`idMusic`) REFERENCES `music` (`id`),
ADD CONSTRAINT `playlistmusic_ibfk_2` FOREIGN KEY (`idPlaylist`) REFERENCES `playlist` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
