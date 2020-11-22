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

-- Dumping data for table webcaycanh.categories: ~4 rows (approximately)
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

-- Dumping data for table webcaycanh.category_post: ~8 rows (approximately)
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
	('fc969d16-1f03-4b39-92ad-4cd700cb794e', 2);
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
  `post_id` int(11) NOT NULL DEFAULT '0',
  `created_date` datetime NOT NULL,
  `edited_date` datetime NOT NULL,
  `content` varchar(225) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.comments: ~0 rows (approximately)
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
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
	(20),
	(20),
	(20),
	(20),
	(20);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.images
CREATE TABLE IF NOT EXISTS `images` (
  `id` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.images: ~1 rows (approximately)
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` (`id`, `url`, `is_deleted`) VALUES
	(12, '/images/post/945a5c97-bbdb-4671-8961-bf46c5958f60.png', 0),
	(13, '/images/post/647e8209-86cc-4afe-8bba-2dd650a2388c.png', 0),
	(14, '/images/post/c1357a6f-a540-4f28-bfa1-28fc94501613.png', 0),
	(15, '/images/post/df47ac4a-b80e-4464-bc00-1a59d5b55d8f.png', 0),
	(16, '/images/post/e8cf6e28-b2a1-427a-b28b-5823857d9487.png', 0),
	(17, '/images/post/aa6b2aa9-4ee8-4342-bcf2-db0f8e5cbf5d.png', 0),
	(18, '/images/post/d52490bd-585f-4232-8a84-211f812fe761.png', 0),
	(19, '/images/post/5069660b-c307-4a54-a52d-69da3487832e.png', 0);
/*!40000 ALTER TABLE `images` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.posts
CREATE TABLE IF NOT EXISTS `posts` (
  `id` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
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

-- Dumping data for table webcaycanh.posts: ~0 rows (approximately)
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` (`id`, `content`, `created_date`, `edited_date`, `title`, `user_id`, `image_id`, `is_deleted`) VALUES
	('28044a54-f88e-4230-8b93-5507e68b11e5', '', '2020-11-20', NULL, 'a', 0, 18, 0),
	('5344bb84-d774-4cf1-a4a1-966391673a61', 'interdum arcu blandit, vehicula magna non, placerat elit. Mauris et pharetratortor. Susp', '2020-11-08', NULL, 'khoa', 0, 12, 0),
	('5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', 'Sometimes a boy just wants to know wether or not he is loved..... And if  no one tells him..... Things get messy.\r\n', '2020-11-20', NULL, 'Test', 0, 15, 0),
	('bd55bdc4-a66c-4df9-81fb-c60a2446f794', 'This was my dad, I eventually distanced from him, as I got older he would complain that I would not treat him like a father, that\'s because he never treated me like a son.\r\n\r\n', '2020-11-20', NULL, 'abc', 0, 14, 0),
	('e819ddcc-815c-4ce9-b597-4633cadbf1d8', 'ponent, it\'s marked checked. This method is valid for custom attributesth:attr also. Consider following example:', '2020-11-14', NULL, 'khoatrtrtr', 0, 13, 0),
	('ec663ca6-0e39-44e0-9a86-43bf6f8efc45', '', '2020-11-20', NULL, 'abc', 0, 19, 1),
	('f29f1141-54c8-44c8-bb5d-a514cac3997d', 'u Endo\'s Novel "Silence" is not only a masterwork of filmmaking but also an uncomfortable and profound meditation on Christianity. In this video essay I explore the spirituality of "Silence" and its deconstruction', '2020-11-20', NULL, 'Test', 0, 16, 1),
	('fc969d16-1f03-4b39-92ad-4cd700cb794e', 'sdfsdf', '2020-11-20', NULL, 'a', 0, 17, 0);
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
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.roles: ~0 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
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
  `id` int(11) NOT NULL,
  `created_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.users: ~0 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
