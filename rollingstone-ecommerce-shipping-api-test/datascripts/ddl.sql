CREATE TABLE `ROLLINGSTONE_SHIPPING` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `arrival_date` DATETIME NOT NULL,
  `days_in_transit` INT(11) NOT NULL,
  `is_available` BIT(1) NOT NULL,
  `is_free` BIT(1) NOT NULL,
  `IS_FREE_FOR_MEMBERS` BIT(1) NOT NULL,
  `offer_id` BIGINT(20) NOT NULL,
  `SHIPPING_CARRIER` VARCHAR(255) NOT NULL,
  `shipping_charge` DOUBLE NOT NULL,
  `shipping_mode` VARCHAR(255) NOT NULL,
  `order_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Order_Shipping` (`order_id`),
  CONSTRAINT `FK_Order_Shipping` FOREIGN KEY (`order_id`) REFERENCES `ROLLINGSTONE_ORDER` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=LATIN1;

CREATE TABLE `rollingstone_shipping_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `qty_shipped` int(11) NOT NULL,
  `uom` varchar(255) NOT NULL,
  `unit_price` double NOT NULL,
  `shipping_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq9q7j80yinenfyksrqo7cbne5` (`shipping_id`),
  CONSTRAINT `FKq9q7j80yinenfyksrqo7cbne5` FOREIGN KEY (`shipping_id`) REFERENCES `ROLLINGSTONE_SHIPPING` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
