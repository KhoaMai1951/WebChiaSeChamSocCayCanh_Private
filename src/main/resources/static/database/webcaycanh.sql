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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.books: ~5 rows (approximately)
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` (`id`, `name`) VALUES
	(1, 'a'),
	(2, 'b'),
	(3, 'c'),
	(4, 'd'),
	(5, 'e');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_type_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(225) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.categories: ~0 rows (approximately)
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.category_post
CREATE TABLE IF NOT EXISTS `category_post` (
  `category_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.category_post: ~0 rows (approximately)
/*!40000 ALTER TABLE `category_post` DISABLE KEYS */;
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

-- Dumping structure for table webcaycanh.images
CREATE TABLE IF NOT EXISTS `images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(225) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `post_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.images: ~0 rows (approximately)
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
/*!40000 ALTER TABLE `images` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.posts
CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `created_date` datetime NOT NULL,
  `edited_date` datetime NOT NULL,
  `image_id` int(11) NOT NULL DEFAULT '0',
  `content` text NOT NULL,
  `title` varchar(225) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.posts: ~0 rows (approximately)
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
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
  `name` varchar(225) NOT NULL DEFAULT '0',
  `decription` varchar(225) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.roles: ~2 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`, `decription`) VALUES
	(1, 'ADMIN', 'Quản trị viên trang web'),
	(2, 'USER', 'Người dùng của trang web');
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
  `role_id` int(11) NOT NULL DEFAULT '0',
  `username` varchar(225) NOT NULL DEFAULT '0',
  `email` varchar(225) NOT NULL DEFAULT '0',
  `password` varchar(225) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.users: ~1 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `role_id`, `username`, `email`, `password`, `is_deleted`, `created_date`) VALUES
	(1, 1, 'dangkhoa', 'khoa@gmail.com', '123', 0, '2020-10-17 16:59:37');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
