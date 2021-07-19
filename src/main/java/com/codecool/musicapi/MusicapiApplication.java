package com.codecool.musicapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicapiApplication.class, args);

		/*SessionFactory sessionFactory = HibernateUtil.getInstance();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		//session.save(new Artist("Morgan King"));
		*//*session.save(new Genre("Soul"));
		session.save(new Album("Broken Disco"));
		session.save(new Playlist("Booming boombox megamix"));
		session.save(new Song("Wish me Love", "Morgan King"));*//*

		transaction.commit();

		session.close();
		sessionFactory.close();*/
	}

}
