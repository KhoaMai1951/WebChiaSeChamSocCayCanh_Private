-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.15 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for webcaycanh
CREATE DATABASE IF NOT EXISTS `webcaycanh` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `webcaycanh`;

-- Dumping structure for table webcaycanh.books
CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.books: ~0 rows (approximately)
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
/*!40000 ALTER TABLE `books` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_type_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.categories: ~5 rows (approximately)
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` (`id`, `category_type_id`, `is_deleted`, `name`) VALUES
	(1, 1, 0, 'Bonsai'),
	(2, 1, 0, 'Xương rồng'),
	(3, 1, 0, 'Cây cảnh văn phòng'),
	(4, 2, 0, 'Mẹo vặt'),
	(5, 2, 0, 'Sự kiện');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.category_post
CREATE TABLE IF NOT EXISTS `category_post` (
  `post_id` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.category_post: ~23 rows (approximately)
/*!40000 ALTER TABLE `category_post` DISABLE KEYS */;
INSERT INTO `category_post` (`post_id`, `category_id`) VALUES
	('5344bb84-d774-4cf1-a4a1-966391673a61', 1),
	('5344bb84-d774-4cf1-a4a1-966391673a61', 2),
	('5344bb84-d774-4cf1-a4a1-966391673a61', 4),
	('e819ddcc-815c-4ce9-b597-4633cadbf1d8', 1),
	('e819ddcc-815c-4ce9-b597-4633cadbf1d8', 2),
	('e819ddcc-815c-4ce9-b597-4633cadbf1d8', 3),
	('e819ddcc-815c-4ce9-b597-4633cadbf1d8', 4),
	('e819ddcc-815c-4ce9-b597-4633cadbf1d8', 5),
	('bd55bdc4-a66c-4df9-81fb-c60a2446f794', 1),
	('bd55bdc4-a66c-4df9-81fb-c60a2446f794', 4),
	('bd55bdc4-a66c-4df9-81fb-c60a2446f794', 5),
	('5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', 2),
	('5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', 5),
	('f29f1141-54c8-44c8-bb5d-a514cac3997d', 2),
	('f29f1141-54c8-44c8-bb5d-a514cac3997d', 5),
	('fc969d16-1f03-4b39-92ad-4cd700cb794e', 2),
	('29a367b6-09d2-4e33-a01c-3c906fcf8151', 2),
	('29a367b6-09d2-4e33-a01c-3c906fcf8151', 4),
	('87eb7a50-be8b-4dc5-829d-8062f9dc8052', 2),
	('87eb7a50-be8b-4dc5-829d-8062f9dc8052', 4),
	('ba47e56f-a884-4bab-ac44-cb1de0421751', 1),
	('ba47e56f-a884-4bab-ac44-cb1de0421751', 2),
	('ba47e56f-a884-4bab-ac44-cb1de0421751', 5);
/*!40000 ALTER TABLE `category_post` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.category_types
CREATE TABLE IF NOT EXISTS `category_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.category_types: ~2 rows (approximately)
/*!40000 ALTER TABLE `category_types` DISABLE KEYS */;
INSERT INTO `category_types` (`id`, `name`, `is_deleted`) VALUES
	(1, 'caycanh', 0),
	(2, 'noidung', 0);
/*!40000 ALTER TABLE `category_types` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.comments
CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `post_id` varchar(225) NOT NULL DEFAULT '0',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edited_date` datetime DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.comments: ~9 rows (approximately)
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` (`id`, `user_id`, `post_id`, `created_date`, `edited_date`, `content`) VALUES
	(37, 1, '28044a54-f88e-4230-8b93-5507e68b11e5', '2020-12-06 00:00:00', NULL, '1'),
	(38, 1, '29a367b6-09d2-4e33-a01c-3c906fcf8151', '2020-12-06 00:00:00', NULL, '2'),
	(39, 2, '5344bb84-d774-4cf1-a4a1-966391673a61', '2020-12-06 00:00:00', NULL, '3'),
	(40, 1, '5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', '2020-12-11 00:00:00', NULL, 'sefsdfg'),
	(41, 1, '875a5258-1b40-4b8c-ba6a-6675115e0a48', '2020-12-11 00:00:00', NULL, 'gud gud'),
	(47, 2, '875a5258-1b40-4b8c-ba6a-6675115e0a48', '2020-12-11 00:00:00', NULL, 'Pedro Pascal, who plays Oberyn Martell in Game of Thrones and Javier Peña in Narcos shares his ten essentials, including black coffee, Cap\'n Crunch, and The Magic Mountain by Thomas Mann. Pedro stars in "The Equalizer 2," out in theaters July 20th. \r\n'),
	(48, 2, '875a5258-1b40-4b8c-ba6a-6675115e0a48', '2020-12-11 00:00:00', NULL, 'Pedro Pascal, who plays Oberyn Martell in Game of Thrones and Javier Peña in Narcos shares his ten essentials, including black coffee, Cap\'n Crunch, and The Magic Mountain by Thomas Mann. Pedro stars in "The Equalizer 2," out in theaters July 20th. \r\nPedro Pascal, who plays Oberyn Martell in Game of Thrones and Javier Peña in Narcos shares his ten essentials, including black coffee, Cap\'n Crunch, and The Magic Mountain by Thomas Mann. Pedro stars in "The Equalizer 2," out in theaters July 20th. \r\n'),
	(49, 2, '5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', '2020-12-11 00:00:00', NULL, 'Pedro Pascal, who plays Oberyn Martell in Game of Thrones and Javier Peña in Narcos shares his ten essentials, including black coffee, Cap\'n Crunch, and The Magic Mountain by Thomas Mann. Pedro stars in "The Equalizer 2," out in theaters July 20th. \r\n'),
	(50, 2, '5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', '2020-12-11 00:00:00', NULL, 'Pedro Pascal, who plays Oberyn Martell in Game of Thrones and Javier Peña in Narcos shares his ten essentials, including black coffee, Cap\'n Crunch, and The Magic Mountain by Thomas Mann. Pedro stars in "The Equalizer 2," out in theaters July 20th. \r\n'),
	(51, 2, '5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', '2020-12-11 00:00:00', NULL, 'SELECT COUNT(p.user_id) AS post_num, p.user_id FROM posts p GROUP BY p.user_id');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.following_users
CREATE TABLE IF NOT EXISTS `following_users` (
  `user_id` int(11) DEFAULT NULL,
  `following_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.following_users: ~0 rows (approximately)
/*!40000 ALTER TABLE `following_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `following_users` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.hibernate_sequence: ~5 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(52),
	(52),
	(52),
	(52),
	(52);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.images
CREATE TABLE IF NOT EXISTS `images` (
  `id` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.images: ~13 rows (approximately)
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` (`id`, `url`, `is_deleted`) VALUES
	(12, '/images/post/945a5c97-bbdb-4671-8961-bf46c5958f60.png', 0),
	(13, '/images/post/647e8209-86cc-4afe-8bba-2dd650a2388c.png', 0),
	(14, '/images/post/c1357a6f-a540-4f28-bfa1-28fc94501613.png', 0),
	(15, '/images/post/df47ac4a-b80e-4464-bc00-1a59d5b55d8f.png', 0),
	(16, '/images/post/e8cf6e28-b2a1-427a-b28b-5823857d9487.png', 0),
	(17, '/images/post/aa6b2aa9-4ee8-4342-bcf2-db0f8e5cbf5d.png', 0),
	(18, '/images/post/d52490bd-585f-4232-8a84-211f812fe761.png', 0),
	(19, '/images/post/5069660b-c307-4a54-a52d-69da3487832e.png', 0),
	(20, '/images/post/d7334e5d-f156-4bc2-b8dc-96170813e376.png', 0),
	(21, '/images/post/97991c35-4da1-4873-bc87-10b52f09966c.png', 0),
	(22, '/images/post/70691499-fdd2-4889-b7bc-c3d613180b81.png', 0),
	(43, '/images/post/39506c75-58ef-4e2e-9438-7125c887cecd.png', 0),
	(44, '/images/post/a1847c61-7b75-499d-a314-f63953587fae.png', 0);
/*!40000 ALTER TABLE `images` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.posts
CREATE TABLE IF NOT EXISTS `posts` (
  `id` varchar(255) NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `created_date` date DEFAULT NULL,
  `edited_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `image_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FKdt44ngxibfjiwb1w59qd23xmw` (`image_id`),
  CONSTRAINT `FKdt44ngxibfjiwb1w59qd23xmw` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.posts: ~11 rows (approximately)
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` (`id`, `content`, `created_date`, `edited_date`, `title`, `user_id`, `image_id`, `is_deleted`) VALUES
	('28044a54-f88e-4230-8b93-5507e68b11e5', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n\r\nWhy do we use it?\r\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\r\n\r\n\r\nWhere does it come from?\r\nContrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.', '2020-11-20', NULL, '8 cách chăm sóc cây cảnh trong nhà để cây luôn xanh và phát triển tốt', 2, 18, 0),
	('29a367b6-09d2-4e33-a01c-3c906fcf8151', 'hfhrf', '2020-11-22', NULL, 'Hướng dẫn chăm sóc cây cảnh', 1, 20, 0),
	('5344bb84-d774-4cf1-a4a1-966391673a61', 'interdum arcu blandit, vehicula magna non, placerat elit. Mauris et pharetratortor. Susp', '2020-11-08', NULL, 'Hướng dẫn trồng và chăm sóc cây cảnh trong chậu đúng cách', 1, 12, 0),
	('5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', 'Sometimes a boy just wants to know wether or not he is loved..... And if  no one tells him..... Things get messy.\r\n', '2020-11-20', NULL, 'CÁCH TRỒNG BƠ TRONG VƯỜN SIÊU DỄ CHO RA SAI TRĨU QUẢ', 1, 15, 0),
	('875a5258-1b40-4b8c-ba6a-6675115e0a48', 'edd', '2020-11-22', NULL, 'TỔNG HỢP những cách chăm sóc cây xanh trong vườn luôn tươi tốt', 1, 21, 0),
	('87eb7a50-be8b-4dc5-829d-8062f9dc8052', 'userId', '2020-12-11', NULL, 'Heck yeah! You and the crew need to come back to Utah!', 1, 43, 0),
	('8ee2dc57-d921-4678-9ed7-8d23446d0abf', '', '2020-11-22', NULL, 'Kỹ thuật và cách chăm sóc cây xoài cho quả SIÊU TO khổng lồ', 1, 22, 0),
	('ba47e56f-a884-4bab-ac44-cb1de0421751', 'Damn japanese 80s music is so damn good\r\n\r\n', '2020-12-11', NULL, 'Damn japanese 80s music is so damn good', 1, 44, 0),
	('bd55bdc4-a66c-4df9-81fb-c60a2446f794', 'This was my dad, I eventually distanced from him, as I got older he would complain that I would not treat him like a father, that\'s because he never treated me like a son.\r\n\r\n', '2020-11-20', NULL, 'Kỹ thuật trồng cam SAI QUẢ trong thời gian ngắn nhất', 1, 14, 0),
	('e819ddcc-815c-4ce9-b597-4633cadbf1d8', 'ponent, it\'s marked checked. This method is valid for custom attributesth:attr also. Consider following example:', '2020-11-14', NULL, '[TẤT TẦN TẬT] Kỹ thuật tưới nước cho cây tiêu HIỆU QUẢ nhất', 1, 13, 0),
	('ec663ca6-0e39-44e0-9a86-43bf6f8efc45', '', '2020-11-20', NULL, 'abc', 1, 19, 0),
	('f29f1141-54c8-44c8-bb5d-a514cac3997d', 'u Endo\'s Novel "Silence" is not only a masterwork of filmmaking but also an uncomfortable and profound meditation on Christianity. In this video essay I explore the spirituality of "Silence" and its deconstruction', '2020-11-20', NULL, 'Test', 1, 16, 0),
	('fc969d16-1f03-4b39-92ad-4cd700cb794e', 'sdfsdf', '2020-11-20', NULL, 'a', 1, 17, 0);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.reports
CREATE TABLE IF NOT EXISTS `reports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report_subject_id` int(11) NOT NULL DEFAULT '0',
  `subject_id` int(11) NOT NULL DEFAULT '0',
  `report_title_id` int(11) NOT NULL DEFAULT '0',
  `is_handled` tinyint(4) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `report_action_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.reports: ~0 rows (approximately)
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.report_actions
CREATE TABLE IF NOT EXISTS `report_actions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` enum('DELETE','PASS') NOT NULL,
  `description` varchar(225) NOT NULL DEFAULT '0',
  `admin_id` int(11) NOT NULL DEFAULT '0',
  `admin_comments` varchar(225) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.report_actions: ~0 rows (approximately)
/*!40000 ALTER TABLE `report_actions` DISABLE KEYS */;
/*!40000 ALTER TABLE `report_actions` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.roles: ~2 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `description`, `name`) VALUES
	(1, NULL, 'user'),
	(2, NULL, 'admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.saved_posts
CREATE TABLE IF NOT EXISTS `saved_posts` (
  `post_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.saved_posts: ~0 rows (approximately)
/*!40000 ALTER TABLE `saved_posts` DISABLE KEYS */;
/*!40000 ALTER TABLE `saved_posts` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.users: ~2 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `created_date`, `email`, `is_deleted`, `password`, `username`, `role_id`) VALUES
	(1, '2020-11-28', 'khoa@gmail.com', 0, '1', 'khoa1941', 1),
	(2, '2020-11-28', 'khoa1@gmail.com', 0, '1', 'skywalker', 1),
	(3, NULL, 'khoa2@gmail.com', 0, '1', 'rw', 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
