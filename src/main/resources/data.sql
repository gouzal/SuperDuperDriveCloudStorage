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
  (10,'a','3fI66PA5cb2OmhzkhT+PLQ==','a9BHQEdkOe1PfF/I0yfTwA==','Mary','Wylie');


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

INSERT INTO CREDENTIALS (credentialid,url,username,password,key,userid)
VALUES
  (1,'http://netflix.com','Hayfa','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',3),
  (2,'http://facebook.com','Dalton','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',7),
  (3,'https://netflix.com','Zane','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',2),
  (4,'https://baidu.com','Briar','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',6),
  (5,'https://bbc.co.uk','Marshall','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',5),
  (6,'https://yahoo.com','Charde','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',2),
  (7,'http://nytimes.com','Lacy','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',9),
  (8,'https://netflix.com','Yeo','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',2),
  (9,'https://bbc.co.uk','Jessamine','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',2),
  (10,'http://reddit.com','Kasimir','awn1hSz6gSt7F91rsGrhBw==','SchLfwcYUU4yqoP5G9tgLA==',2);
