CREATE TABLE `rollingstone_pricing` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
 `pcode` varchar(255) NOT NULL,
  `PRICE_ID` varchar(255) NOT NULL,
   `member_type` varchar(255) NOT NULL,
    `PRICE_TYPE` varchar(255) NOT NULL,
      `label` double NOT NULL,
       `DISPLAY` varchar(255) NOT NULL,
         `ORIG_PRICE` double NOT NULL,
           `DISC_PRICE` double NOT NULL,
             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;