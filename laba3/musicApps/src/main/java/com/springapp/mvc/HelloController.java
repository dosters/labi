package com.springapp.mvc;
import com.dropbox.core.DbxException;
import com.springapp.mvc.dao.MusiclikespersonDaoImpl;
import com.springapp.mvc.domain.*;
import com.springapp.mvc.service.*;
import com.sun.javafx.scene.layout.region.Margins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.transport.proxy.RMIHttpToPortSocketFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
@SessionAttributes("usermy")
public class HelloController {
	@Autowired
	private MusiclikedPersonService musiclikedpersonService;
	@Autowired
	private PlaylistlikedPersonService playlistlikedPersonService;
	@Autowired
	private PersonService personService;
	@Autowired
	private PersonMusicService personMusicService;
	@Autowired
	private PersonPlaylistService personPlaylistService;
	@Autowired
	private MusicService musicService;
	@Autowired
	private PlaylistService playlistService;
	@Autowired
	private PlaylistMusicService playlistMusicService;
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model) {
		model.addAttribute("person", new PersonEntity());
		return new ModelAndView("hello");
	}
	@RequestMapping(value = "index",method = RequestMethod.GET)
	public ModelAndView listPersons(ModelMap model)
	{
		Object personEntity=model.get("usermy");
		PersonEntity person=(PersonEntity)personEntity;
		ModelAndView modelAndView=new ModelAndView("index");
		List<PersonEntity> persons=personService.top();
		List<MusicEntity> musics=musicService.top();
		for(MusicEntity e:musics)
		{
			System.out.println(e.getScr());
		}
		List<PlaylistEntity> playlists=playlistService.top();
		modelAndView.addObject("persons", persons);
		modelAndView.addObject("users", person);
		modelAndView.addObject("musics",musics);
		modelAndView.addObject("playlists", playlists);
		return modelAndView;
	}
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String userHome()
	{
		return "redirect:/index";
	}
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login()
	{
		return "redirect:/";
	}
	@RequestMapping(value = "/userExit",method = RequestMethod.GET)
	public String userExit()
	{
		return "redirect:/";
	}
	@RequestMapping(value = "/WithOutAuth",method = RequestMethod.POST)
	public String WithOutAuth(Model model) {
		model.addAttribute("usermy",  personService.getPersonFromId(6));
		return "redirect:index";
	}
	@RequestMapping(value = "/admin",method =RequestMethod.GET )
	public String adminka(Model model)
	{
		model.addAttribute("person",new PersonEntity());
		model.addAttribute("erorMessage","");
		return "adminPage";
	}
	@RequestMapping(value = "/admins",method =RequestMethod.GET )
	public String admins(Model model)
	{
		//model.addAttribute("person",new PersonEntity());
		model.addAttribute("musics",musicService.getAllMusic());
		return "admins";
	}
	@RequestMapping(value = "/adminAuth",method = RequestMethod.POST)
	public String adminAuth(@ModelAttribute PersonEntity personEntity,Model model) {
		if(personEntity.getName().equals("admin")==true && personEntity.getLastName().equals("1995")==true)
		{
			personEntity.setId(personService.add(personEntity));
			model.addAttribute("playlists",playlistService.getAll());
			System.out.println(personEntity.getName());
			model.addAttribute("musics",musicService.getAllMusic());
			return "admins";
		}
		else
		{
			model.addAttribute("erorMessage","Eror! Please input correct");
			return "adminPage";
		}
	}
	@RequestMapping(value = "/addPerson",method = RequestMethod.POST)
	public String addPerson(@ModelAttribute PersonEntity personEntity,Model model) {
		personEntity.setId(personService.add(personEntity));
		model.addAttribute("usermy", personEntity);
		return "redirect:index";
	}
	@RequestMapping(value = "/addPlaylist",method = RequestMethod.POST)
	public String addPlaylist(@ModelAttribute PlaylistEntity playlistEntity,@ModelAttribute("id") String id, Model model) {
		int ids= Integer.parseInt(id);
		playlistEntity.setId(0);
		playlistEntity.setLikes(0);
		playlistService.add(playlistEntity);
		PlaylistEntity pr=playlistService.getFromId(playlistEntity.getName());
//		PersonplaylistEntity itog=new PersonplaylistEntity(ids,pr.getId());
//		System.out.println(itog.getId()+" "+itog.getIdPerson()+" "+itog.getIdPlaylist());
		personPlaylistService.add(ids,pr.getId());
		model.addAttribute("users", personService.getPersonFromId(ids));
		model.addAttribute("playlists", playlistService.personPlaylists(ids));
		return "playlist";
	}
	@RequestMapping(value = "/myPlaylist",method = RequestMethod.GET)
	 public String getPlaylist(@RequestParam(value = "id",required = true) Integer id,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(id));
		model.addAttribute("playlists", playlistService.personPlaylists(id));
		model.addAttribute("playlist",new PlaylistEntity());
		return "playlist";
	}
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public String search( @ModelAttribute("textSearch") String s,
						  @ModelAttribute("id") String id,
						  Model model)
	{
		int ids= Integer.parseInt(id);
		model.addAttribute("users", personService.getPersonFromId(ids));
		model.addAttribute("musics",musicService.search(s));
		return "search";
	}
	@RequestMapping(value = "/myMusic",method = RequestMethod.GET)
	public String getMusic(@RequestParam(value = "id",required = true) Integer id,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(id));
		model.addAttribute("musics", musicService.getMusic(id));
		model.addAttribute("Music", new MusicEntity());
		return "music";
	}
	@RequestMapping(value = "/playlistMusicIndex",method = RequestMethod.GET)
	public String playlistMusicIndex(@RequestParam(value = "id",required = true) Integer id,
									 @RequestParam(value = "idPlaylist",required = true) int idPlaylist,
									 @RequestParam(value = "idPerson",required = true) int idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(id));
		model.addAttribute("musics", musicService.playlistMusic(idPlaylist));
		model.addAttribute("idPlaylist", idPlaylist);
		model.addAttribute("idPerson",idPerson);
		return "musicForPlaylist";
	}
	@RequestMapping(value = "/allMusic",method = RequestMethod.GET)
	public String getAllMusic(@RequestParam(value = "id",required = true) Integer id,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(id));
		model.addAttribute("musics",musicService.getAllMusic());
		return "allmusic";
	}
	@RequestMapping(value = "/allPlaylist",method = RequestMethod.GET)
	 public String getAllPerson(@RequestParam(value = "id",required = true) Integer id,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(id));
		model.addAttribute("playlists",playlistService.getAll());
		return "allplaylist";
	}
	@RequestMapping(value = "/allUsers",method = RequestMethod.GET)
	public String getAllUsers(@RequestParam(value = "id",required = true) Integer id,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(id));
		model.addAttribute("persons", personService.list());
		return "allpersons";
	}
	@RequestMapping(value = "/addMusic",method = RequestMethod.GET)
	public String addMusic(@RequestParam(value = "idMusic",required = true) Integer idMusic,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		personMusicService.add(new PersonmusicEntity(idMusic, idPerson));
		return "redirect:index";
	}
	@RequestMapping(value = "/addMusicFromSearch",method = RequestMethod.GET)
	public String addMusicFromSearch(@RequestParam(value = "idMusic",required = true) Integer idMusic,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		personMusicService.add(new PersonmusicEntity(idMusic, idPerson));
		return "redirect:index";
	}

	@RequestMapping(value = "/addMusicFormUserPlaylist",method = RequestMethod.GET)
	public String addMusicFromUserPlaylist(@RequestParam(value = "idMusic",required = true) Integer idMusic,
									 @RequestParam(value = "idPerson",required = true) Integer idPerson,
									 @RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,
										   @RequestParam(value = "idPersonRedirect",required = true) Integer idPersonRedirect,
										   Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		personMusicService.add(new PersonmusicEntity(idMusic, idPerson));
		return "redirect:playlistMusicIndex?id="+idPerson+"&idPlaylist="+idPlaylist+"&idPerson="+idPersonRedirect;
	}
	@RequestMapping(value = "/likeMusicFromuserPlaylist",method = RequestMethod.GET)
	public String likeMusicFromuserPlaylist(@RequestParam(value = "idMusic",required = true) Integer idMusic,
										   @RequestParam(value = "idPerson",required = true) Integer idPerson,
										   @RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,
										   @RequestParam(value = "idPersonRedirect",required = true) Integer idPersonRedirect,
										   Model model)
	{
		model.addAttribute("users",personService.getPersonFromId(idPerson));
		musicService.like(idMusic, idPerson);
		return "redirect:playlistMusicIndex?id="+idPerson+"&idPlaylist="+idPlaylist+"&idPerson="+idPersonRedirect;
	}

	@RequestMapping(value = "/addMusicFromPerson",method = RequestMethod.GET)
	public String addMusicFromPerson(@RequestParam(value = "idMusic",required = true) Integer idMusic,
									 @RequestParam(value = "idPersonMain",required = true) Integer idPersonMain,
									 @RequestParam(value = "idPersonRedirect",required = true) Integer idPersonRedirect,
									 Model model)
	{
		model.addAttribute("users",personService.getPersonFromId(idPersonMain));
		personMusicService.add(new PersonmusicEntity(idMusic, idPersonMain));

		return "redirect:personInfo?id="+idPersonMain+"&personId="+idPersonRedirect;
	}
	@RequestMapping(value = "/likeMusicFromPerson",method = RequestMethod.GET)
	public String likeMusicFromPerson(@RequestParam(value = "idMusic",required = true) Integer idMusic,
									 @RequestParam(value = "idPersonMain",required = true) Integer idPersonMain,
									 @RequestParam(value = "idPersonRedirect",required = true) Integer idPersonRedirect,
									 Model model)
	{
		model.addAttribute("users",personService.getPersonFromId(idPersonMain));
		musicService.like(idMusic, idPersonMain);
		return "redirect:personInfo?id="+idPersonMain+"&personId="+idPersonRedirect;
	}

	@RequestMapping(value = "/addMusicTop",method = RequestMethod.GET)
	public String addMusicTop(@RequestParam(value = "idMusic",required = true) Integer idMusic,
							  @RequestParam(value = "idPerson",required = true) Integer idPerson,
							  @RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,
							  Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		personMusicService.add(new PersonmusicEntity(idMusic, idPerson));
		String str="redirect:playlistMusicIndex?id="+idPerson+"&idPlaylist="+idPlaylist+"&idPerson="+idPerson;
		return str;
	}
	@RequestMapping(value = "/addMusicAll",method = RequestMethod.GET)
	public String addMusicAll(@RequestParam(value = "idMusic",required = true) Integer idMusic,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		personMusicService.add(new PersonmusicEntity(idMusic, idPerson));
		String str="redirect:allMusic?id="+idPerson;
		return str;
	}
	@RequestMapping(value = "/addMusicPlaylist",method = RequestMethod.GET)
	 public String addMusicPlaylist(@RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		model.addAttribute("idPlaylist", idPlaylist);
		model.addAttribute("musics", musicService.getAllMusic());
		return "allmusicPlaylist";
	}
	@RequestMapping(value = "/addMusicPlaylistFinal",method = RequestMethod.GET)
	public String addMusicPlaylistFinal(@RequestParam(value = "idMusic",required = true) Integer idMusic,@RequestParam(value = "idPerson",required = true) Integer idPerson,@RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		playlistMusicService.add(idMusic, idPlaylist);
		model.addAttribute("idPlaylist",idPlaylist);
		model.addAttribute("musics", musicService.getAllMusic());
		return "allmusicPlaylist";
	}
	@RequestMapping(value = "/delMusic",method = RequestMethod.GET)
	public String delMusic(@RequestParam(value = "idMusic",required = true) Integer idMusic,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		personMusicService.delete(new PersonmusicEntity(idMusic, idPerson));
		playlistMusicService.deleteMP(idMusic);
		String str="redirect:myMusic?id="+idPerson;
		return str;
	}
	@RequestMapping(value = "/delMusicAdmin",method = RequestMethod.GET)
	public String delMusicAdmin(@RequestParam(value = "idMusic",required = true) Integer idMusic,
								Model model)
	{
		playlistMusicService.deleteID(idMusic);
		personMusicService.deleteId(idMusic);
		musiclikedpersonService.delete(idMusic);
		musicService.delete(idMusic);
		model.addAttribute("playlists", playlistService.getAll());
		model.addAttribute("musics", musicService.getAllMusic());
		String str="redirect:admins";
		return str;
	}
	@RequestMapping(value = "/delPlaylistAdmin",method = RequestMethod.GET)
	public String delPlaylistAdmin(@RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,
								Model model)
	{
		personPlaylistService.deleteID(idPlaylist);
		playlistlikedPersonService.delete(idPlaylist);
		playlistMusicService.deleteIdP(idPlaylist);
		playlistService.delete(idPlaylist);
		model.addAttribute("playlists",playlistService.getAll());
		model.addAttribute("musics", musicService.getAllMusic());
		String str="redirect:admins";
		return str;
	}
	@RequestMapping(value = "/delMusicPlaylist",method = RequestMethod.GET)
	public String delMusicPlaylist(@RequestParam(value = "idMusic",required = true) Integer idMusic,
								   @RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,
								   @RequestParam(value = "idPerson",required = true) Integer idPerson,
								   Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		playlistMusicService.delete(idMusic,idPlaylist);
		String str="redirect:playlistMusic?id="+idPerson+"&idPlaylist="+idPlaylist+"&idPerson="+idPerson;
		return str;
	}
	@RequestMapping(value = "/delPlaylist",method = RequestMethod.GET)
	public String delPlaylist(@RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		personPlaylistService.delete(new PersonplaylistEntity(idPerson, idPlaylist));
		playlistService.delete(idPlaylist);
		String str="redirect:myPlaylist?id="+idPerson;
		return str;
	}
	@RequestMapping(value = "/likeMusic",method = RequestMethod.GET)
	public String likeMusic(@RequestParam(value = "idMusic",required = true) Integer idMusic,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		System.out.println("ASDASDASDAS");
		musicService.like(idMusic, idPerson);
		System.out.println("ASDASDASDAS");
		return "redirect:index";
	}
	@RequestMapping(value = "/likeMusicFromSearch",method = RequestMethod.GET)
	public String likeMusicFromSearch(@RequestParam(value = "idMusic",required = true) Integer idMusic,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		musicService.like(idMusic, idPerson);
		return "redirect:index";
	}
	@RequestMapping(value = "/likeMusicFromTop",method = RequestMethod.GET)
	public String likeMusicFromTop(
									@RequestParam(value = "idMusic",required = true) Integer idMusic,
								   @RequestParam(value = "idPerson",required = true) Integer idPerson,
								   @RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,
								   Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		musicService.like(idMusic,idPerson);
		String str="redirect:playlistMusicIndex?id="+idPerson+"&idPlaylist="+idPlaylist+"&idPerson="+idPerson;
		return str;
	}

	@RequestMapping(value = "/alllikeMusic",method = RequestMethod.GET)
	public String alllikeMusic(@RequestParam(value = "idMusic",required = true) Integer idMusic,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		musicService.like(idMusic, idPerson);
		String str="redirect:allMusic?id="+idPerson;
		return str;
	}
	@RequestMapping(value = "/llikeMusic",method = RequestMethod.GET)
	public String llikeMusic(@RequestParam(value = "idMusic",required = true) Integer idMusic,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		musicService.like(idMusic,idPerson);
		String str="redirect:myMusic?id="+idPerson;
		return str;
	}
	@RequestMapping(value = "/likePlaylist",method = RequestMethod.GET)
	public String likePlaylist(@RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		playlistService.like(idPlaylist,idPerson);
		return "redirect:index";
	}
	@RequestMapping(value = "/likePlaylistIndex",method = RequestMethod.GET)
	public String likePlaylistIndex(@RequestParam(value = "id",required = true) Integer id,
									@RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,
									@RequestParam(value = "idPerson",required = true) Integer idPerson,
									Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(id));
		playlistService.like(idPlaylist,id);
		String str="redirect:personInfo?id="+id+"&personId="+idPerson;
		return str;
	}

	@RequestMapping(value = "/alllikePlaylist",method = RequestMethod.GET)
	public String alllikePlaylist(@RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(idPerson));
		playlistService.like(idPlaylist,idPerson);
		String str="redirect:allPlaylist?id="+idPerson;
		return str;
	}
	@RequestMapping(value = "/playlistMusic",method = RequestMethod.GET)
	public String playlistMusic(@RequestParam(value = "id",required = true) Integer id,@RequestParam(value = "idPlaylist",required = true) Integer idPlaylist,@RequestParam(value = "idPerson",required = true) Integer idPerson,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(id));
		model.addAttribute("idPlaylist",idPlaylist);
		model.addAttribute("playlists", playlistService.personPlaylists(id));
		model.addAttribute("playlistMusics", musicService.playlistMusic(idPlaylist));
		return "playlistMusic";

	}
	@RequestMapping(value = "/personInfo",method = RequestMethod.GET)
	public String personInfo(@RequestParam(value = "id",required = true) Integer id,
							 @RequestParam(value = "personId",required = true) Integer personId,Model model)
	{
		model.addAttribute("users", personService.getPersonFromId(id));
		model.addAttribute("playlists", playlistService.personPlaylists(personId));
		model.addAttribute("personId",personId);
		model.addAttribute("musics",musicService.getMusic(personId));
		return "userMusicPlaylist";
	}
	@RequestMapping(value = "/addMusicPost",method = RequestMethod.GET)
	public String addMusicGet(Model model)
	{
		model.addAttribute("Music", new MusicEntity());
		return "redirect:/addMusicPost";
	}
	@RequestMapping(value = "/addMusicPost",method = RequestMethod.POST)
	public String addMusicPost(@RequestParam(value = "id",required = true) Integer id,
							   @ModelAttribute MusicEntity musicEntity,Model model) throws IOException, DbxException {
		String url = DropBox.UpLoad(musicEntity.getScr());
		String name = musicEntity.getScr();
		System.out.println(name);
		Integer likes = 0;
		MusicEntity music = new MusicEntity(likes, name, url);
		musicService.add(music);
		List<MusicEntity> musicEntities = musicService.getAllMusic();
		for (MusicEntity m : musicEntities) {
			if (m.getName().equals(name) == true) {
				personMusicService.add(new PersonmusicEntity(m.getId(), id));
			}
		}
		return "redirect:myMusic?id="+id;
	}

}