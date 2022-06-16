package com.douzone.container.config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
/*
* 		import
* 		<----- JavaConfig1, JavaConfig2
 * 
 * 
 * 	JavaConfig1 + JavaConfig 2
 */
import org.springframework.context.annotation.Import;

@Configuration
@Import({DVDConfig.class, DVDPlayerConfig.class})
public class VideoSystemConfig {

}
