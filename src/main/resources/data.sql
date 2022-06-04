/**
 * Author:  Larbi
 * Created: 22 mai 2022
 */

INSERT INTO users (userid,username,password,salt,firstname,lastname)
VALUES
  (1,'Gail','JEQ58AXJ7JG','CLL26IVS0DC','Ruth','Duncan'),
  (2,'Zachary','QDZ13OBA4RX','WEN83HTC7QB','Ian','Mara'),
  (3,'Marah','YDT32BRM6LM','SEW32LFN5TQ','Neve','Marshall'),
  (4,'Griffin','BTD75QUR2PZ','IDR07VBI4UX','Rhona','Fitzgerald'),
  (5,'Plato','ETW47NMY2JW','KSO98CHU2NI','Fredericka','Jonas'),
  (6,'Finn','INU58DYD7AW','HCI18OOT8YJ','Tara','Amaya'),
  (7,'Carol','WYS26CUD3GG','MMU49RPV4ZL','Beck','Odysseus'),
  (8,'Jorden','PHC34RRP3VY','AJK14WOG2GW','Quinlan','Fritz'),
  (9,'Madeline','MQE10RXG7YT','MNC84PKL9XJ','Neville','Graiden'),
  (10,'Melodie','HYV48BYU6EA','YXC64UIE5MM','Mary','Wylie');


INSERT INTO notes (noteid,notetitle,notedescription,userid)
VALUES
  (1,'vulputate,','blandit. Nam nulla',8),
  (2,'diam. Pellentesque','Lorem ipsum',6),
  (3,'ut,','pede. Nunc sed orci',2),
  (4,'enim.','neque pellentesque massa',2),
  (5,'natoque penatibus','sem molestie sodales.',4),
  (6,'faucibus orci luctus','eu turpis. Nulla aliquet.',7),
  (7,'molestie. Sed id','posuere, enim nisl elementum',3),
  (8,'convallis','leo. Vivamus nibh',2),
  (9,'augue scelerisque','Pellentesque ut',10),
  (10,'odio semper cursus.','iaculis nec, eleifend',7);
INSERT INTO notes (noteid,notetitle,notedescription,userid)
VALUES
  (11,'neque','feugiat nec,',5),
  (12,'porttitor eros','at risus.',6),
  (13,'magna. Sed eu','eleifend. Cras sed',5),
  (14,'at, velit. Cras','Nulla dignissim.',8),
  (15,'ornare sagittis','et malesuada fames',6),
  (16,'In faucibus.','massa rutrum magna. Cras',5),
  (17,'Pellentesque ut','eget tincidunt',4),
  (18,'dictum augue','non, vestibulum nec,',2),
  (19,'odio. Etiam','Aliquam ornare,',7),
  (20,'nibh sit amet','vel nisl. Quisque',4);

INSERT INTO CREDENTIALS (credentialid,url,username,key,password,userid)
VALUES
  (1,'http://netflix.com','Hayfa','ZSQ18ABX2JB','VSL03QZN4BG',3),
  (2,'http://facebook.com','Dalton','SUI41XHO8QE','XFT31UXT2WU',7),
  (3,'https://netflix.com','Zane','BLD55NHZ1NO','BCN46RDJ8TL',2),
  (4,'https://baidu.com','Briar','KKX49TCF6DN','KBX58VTB8CJ',6),
  (5,'https://bbc.co.uk','Marshall','ABD17RBP6YG','UTR57BXO7KO',5),
  (6,'https://yahoo.com','Charde','IPT39GTX1GE','SNW71OYY8QW',2),
  (7,'http://nytimes.com','Lacy','XHR87PHS4JH','AIK84XVE5PK',9),
  (8,'https://netflix.com','Yeo','YUP79CNP8CH','TJA04QBC0CY',2),
  (9,'https://bbc.co.uk','Jessamine','JVW95BOZ1FV','SQS19NTJ4BN',2),
  (10,'http://reddit.com','Kasimir','YWM96UWY3KM','AYT69JBI7CB',2);
