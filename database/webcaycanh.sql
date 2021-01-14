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

-- Dumping structure for table webcaycanh.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_type_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.categories: ~5 rows (approximately)
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` (`id`, `category_type_id`, `is_deleted`, `name`) VALUES
	(1, 1, 0, 'Bonsai'),
	(2, 1, 0, 'Xương rồng'),
	(3, 1, 0, 'Cây cảnh văn phòng'),
	(4, 2, 0, 'Mẹo vặt'),
	(5, 2, 0, 'Sự kiện'),
	(114, 1, 0, 'cây lan'),
	(115, 1, 0, 'G');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.category_post
CREATE TABLE IF NOT EXISTS `category_post` (
  `post_id` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.category_post: ~38 rows (approximately)
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
	('fc969d16-1f03-4b39-92ad-4cd700cb794e', 2),
	('29a367b6-09d2-4e33-a01c-3c906fcf8151', 2),
	('29a367b6-09d2-4e33-a01c-3c906fcf8151', 4),
	('87eb7a50-be8b-4dc5-829d-8062f9dc8052', 2),
	('87eb7a50-be8b-4dc5-829d-8062f9dc8052', 4),
	('ba47e56f-a884-4bab-ac44-cb1de0421751', 1),
	('ba47e56f-a884-4bab-ac44-cb1de0421751', 2),
	('ba47e56f-a884-4bab-ac44-cb1de0421751', 5),
	('5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', 2),
	('5d918a79-b366-4f47-8fb5-9a1b83ba9bd3', 5),
	('f29f1141-54c8-44c8-bb5d-a514cac3997d', 2),
	('f29f1141-54c8-44c8-bb5d-a514cac3997d', 5),
	('05aee537-d10c-4667-a85f-6e4d7d96db4b', 2),
	('05aee537-d10c-4667-a85f-6e4d7d96db4b', 4),
	('05aee537-d10c-4667-a85f-6e4d7d96db4b', 5),
	('62194ee1-41af-40d4-a723-dea2755b14ed', 2),
	('62194ee1-41af-40d4-a723-dea2755b14ed', 5),
	('86c5fdbd-742c-4f8f-8164-07430b51b410', 2),
	('86c5fdbd-742c-4f8f-8164-07430b51b410', 5),
	('6db4f087-1889-4142-ab58-0496c112a222', 2),
	('6db4f087-1889-4142-ab58-0496c112a222', 5),
	('ffbb7556-c16c-4213-9bd7-86d11ff87c9f', 1),
	('ffbb7556-c16c-4213-9bd7-86d11ff87c9f', 2),
	('ffbb7556-c16c-4213-9bd7-86d11ff87c9f', 5),
	('cec8232e-76d4-4c40-82b9-de288cd7477b', 2),
	('cec8232e-76d4-4c40-82b9-de288cd7477b', 4),
	('cec8232e-76d4-4c40-82b9-de288cd7477b', 5),
	('feb33433-7530-4dce-8306-e7233d9a89c7', 1),
	('feb33433-7530-4dce-8306-e7233d9a89c7', 3),
	('feb33433-7530-4dce-8306-e7233d9a89c7', 4);
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
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.comments: ~2 rows (approximately)
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` (`id`, `user_id`, `post_id`, `created_date`, `edited_date`, `content`, `is_deleted`) VALUES
	(118, 103, 'feb33433-7530-4dce-8306-e7233d9a89c7', '2021-01-14 00:00:00', NULL, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 0),
	(120, 119, 'feb33433-7530-4dce-8306-e7233d9a89c7', '2021-01-14 00:00:00', NULL, 'and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 0);
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
	(121),
	(121),
	(121),
	(121),
	(121);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table webcaycanh.images
CREATE TABLE IF NOT EXISTS `images` (
  `id` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.images: ~14 rows (approximately)
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` (`id`, `url`, `is_deleted`) VALUES
	(12, '/images/post/945a5c97-bbdb-4671-8961-bf46c5958f60.png', 0),
	(13, '/images/post/647e8209-86cc-4afe-8bba-2dd650a2388c.png', 0),
	(14, '/images/post/c1357a6f-a540-4f28-bfa1-28fc94501613.png', 0),
	(15, '/images/post/df47ac4a-b80e-4464-bc00-1a59d5b55d8f.png', 0),
	(16, '/images/post/e8cf6e28-b2a1-427a-b28b-5823857d9487.png', 0),
	(17, '/images/post/aa6b2aa9-4ee8-4342-bcf2-db0f8e5cbf5d.png', 0),
	(20, '/images/post/d7334e5d-f156-4bc2-b8dc-96170813e376.png', 0),
	(43, '/images/post/39506c75-58ef-4e2e-9438-7125c887cecd.png', 0),
	(44, '/images/post/a1847c61-7b75-499d-a314-f63953587fae.png', 0),
	(104, '/images/post/a321e7cd-3a77-423f-aa36-8d9283349b9a.png', 0),
	(109, '/images/post/17ddd5ee-fc7a-48f7-b96b-f8380b3e977e.png', 0),
	(110, '/images/post/485dbc39-f9ba-489c-b73a-ed6096e37172.png', 0),
	(111, '/images/post/4a3d5a56-7447-4b9c-889b-7a4f4ff6a97a.png', 0),
	(112, '/images/post/8a127dc6-8c1c-40ce-81a6-9f60664b1f80.png', 0),
	(113, '/images/post/532a3dc2-36ed-4a0a-8220-32c3d6c0b2cf.png', 0),
	(117, '/images/post/8c5d29f9-f1b9-44df-b688-1beeb784cc2a.png', 0);
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

-- Dumping data for table webcaycanh.posts: ~6 rows (approximately)
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` (`id`, `content`, `created_date`, `edited_date`, `title`, `user_id`, `image_id`, `is_deleted`) VALUES
	('feb33433-7530-4dce-8306-e7233d9a89c7', 'Cây trầu bà (Hoàng Tam Điệp) là loại thân leo, có hoa, thường mọc thành cụm leo, có khả năng thanh lọc không khí, hạn chế bức xạ từ máy tính, sóng wifi, khói thuốc nên rất thích hợp trồng trong phòng ngủ hay phòng khách. Cây trầu bà có màu xanh nên gần như không kiêng kỵ bất cứ tuổi nào, tuy nhiên hợp nhất vẫn là những người tuổi Ngọ.', '2021-01-14', NULL, '99 loại cây cảnh đẹp và dễ trồng trong nhà, sân vườn công trình và để bàn làm việc,', 103, 117, 0);
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
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT '0',
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table webcaycanh.users: ~4 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `created_date`, `email`, `is_deleted`, `password`, `username`, `role_id`) VALUES
	(102, NULL, 'khoa@gmail.com', 0, '$2a$12$6e5lQ5FFeYDbkEWVZ79Ate5dyaL2DM7z78Gq4Q.JfgM9Qzdeq9kk.', 'chronicle1951', 2),
	(103, NULL, 'khoa2@gmail.com', 0, '$2a$12$Z7pvsqQ269R0jbthgEBlaeheFAk1aMZ.gLMs/cFKAwZcBCgY0EegS', 'skywalker', 1),
	(107, NULL, 'khoa1@gmail.com', 1, '$2a$12$UVDr868ucLx.Y5l/WLSE0eeXjZH8i7qoSezqIDkK/uOFnZJ5HjLoK', 'admin', 1),
	(108, NULL, 'admin@gmail.com', 0, '$2a$12$pDDA9lIs5VQzVoLLYId1seB3JeIDxoyBlK9R1.T9eFMOQq4jx8JYi', 'admin', 2),
	(119, NULL, 'chronicle1951@gmail.com', 0, '$2a$12$/QJ61UC3Q3yElMMP46905efueSA3xE8KyjY50Sy2NOQEdJIRUg.SK', 'chronicle1951', 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
