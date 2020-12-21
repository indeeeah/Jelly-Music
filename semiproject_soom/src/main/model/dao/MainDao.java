package main.model.dao;

import java.sql.Connection;
import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.model.vo.MainVO;

public class MainDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

//	public List<MainVO> helloToMem(Connection conn, String mem_id) {
//		List<MainVO> mvo = new ArrayList<MainVO>();
//		String sql = "select mem_aka from member where mem_id=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				do {
//					MainVO vo = new MainVO();
//					vo.setMem_aka(rs.getString("mem_aka"));
//					mvo.add(vo);
//				} while (rs.next());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return mvo;
//	}

	public List<MainVO> searchWord(Connection conn) {
		List<MainVO> svo = new ArrayList<MainVO>();
		String sql = "select * from (select * from search order by sear_hits desc) where rownum<11";// 조건 추가
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setSear_word(rs.getString("sear_word"));
					svo.add(vo);
				} while (rs.next());
			} else {
				System.out.println("데이터가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return svo;
	}

	public List<MainVO> get1to5Top(Connection conn) {
		List<MainVO> tvo = new ArrayList<MainVO>();
		String sql = "select * from (select rownum rnum, m.* "
				+ "from (select mu_every_play, mu_name, art_name, f_name, music.mu_no " + "from music join artist "
				+ "on music.art_no=artist.art_no " + "inner join allfile " + "on artist.f_no=allfile.f_no "
				+ "order by mu_every_play desc) m) " + "where rnum between 1 and 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					tvo.add(vo);
					System.out.println("top 1 to 5 date good");
				} while (rs.next());
			} else {
				System.out.println("top 1 to 5 date is null");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return tvo;
	}

	public List<MainVO> get6to10Top(Connection conn) {
		List<MainVO> tvo = new ArrayList<MainVO>();
		String sql = "select * from (select rownum rnum, m.* "
				+ "from (select mu_every_play, mu_name, art_name, f_name, music.mu_no " + "from music join artist "
				+ "on music.art_no=artist.art_no " + "inner join allfile " + "on artist.f_no=allfile.f_no "
				+ "order by mu_every_play desc) m) " + "where rnum between 6 and 10";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					tvo.add(vo);
					System.out.println("top 6 to 10 date good");
				} while (rs.next());
			} else {
				System.out.println("top 6 to 10 date is null");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return tvo;
	}

	public List<MainVO> getNewRelease(Connection conn) {
		List<MainVO> nvo = new ArrayList<MainVO>();
		String sql = "select * from (select  distinct album.al_no, artist.art_no, AL_RELEASE, al_name, art_name, f_name, music.mu_no "
				+ "from music, artist, allfile, album " + "where music.art_no=artist.art_no "
				+ "and album.f_no=allfile.f_no " + "and music.al_no=album.al_no " + "order by al_release desc) "
				+ "where rownum <6";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setAl_name(rs.getString("al_name"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					nvo.add(vo);
					System.out.println("new release good");
				} while (rs.next());
			} else {
				System.out.println("no release music");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return nvo;
	}

	public List<MainVO> getMood(Connection conn) {
		List<MainVO> mvo = new ArrayList<MainVO>();
		String sql = "select * from (select mo_no, f_name, mo_name " + "from mood, allfile "
				+ "where mood.f_no=allfile.f_no " + "order by dbms_random.value) " + "where rownum<5";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setMo_name(rs.getString("mo_name"));
					vo.setF_name(rs.getString("f_name"));
					mvo.add(vo);
					System.out.println("mood good");
				} while (rs.next());
			} else {
				System.out.println("mood not good");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return mvo;

	}

	public List<MainVO> getMemPlay(Connection conn, String mem_id) {
		List<MainVO> mvo = new ArrayList<MainVO>();
		String sql = "select * from (select rownum rnum, m.* "
				+ "from (select mem_id, mu_name, al_name, art_name, play_date, f_name, music.mu_no "
				+ "from music join album on music.al_no = album.al_no "
				+ "inner join artist on music.art_no = artist.art_no "
				+ "left outer join allfile on album.f_no = allfile.f_no "
				+ "right outer join musichistory on music.mu_no = musichistory.mu_no "
				+ "where mem_id=? and play_now='Y' order by play_date desc) m) " + "where rnum between 1 and 5";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					mvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return mvo;
	}

	public List<MainVO> mayLikeArt(Connection conn, String mem_id) {
		List<MainVO> mvo = new ArrayList<MainVO>();
		String sql = "select * from " + "(select * from (select rownum rnum, m.* "
				+ "from(select art_name, f_name, mu_genre " + "from artist join allfile on artist.f_no = allfile.f_no "
				+ "inner join music on artist.art_no = music.art_no " + "group by mu_genre, art_name, f_name) m) ) a "
				+ "where mu_genre in (select distinct b.mu_genre from "
				+ "(select mu_genre, count(mu_genre), art_name, f_name, mem_id "
				+ "from artist inner join music on artist.art_no = music.art_no "
				+ "inner join allfile on artist.f_no = allfile.f_no "
				+ "inner join musichistory on musichistory.mu_no = music.mu_no "
				+ "group by mu_genre, f_name, art_name, mem_id " + "having mem_id = ? "
				+ "order by count(mu_genre) desc) b)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					mvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return mvo;
	}

	public List<MainVO> mayLikeMusic(Connection conn, String mem_id) {
		List<MainVO> mvo = new ArrayList<MainVO>();
		String sql = "select mem_id, mu_name, music.mu_no, art_name, mu_every_play, mu_every_heart, mu_genre, f_name "
				+ "from heart join music on heart.mu_no = music.mu_no "
				+ "inner join artist on music.art_no = artist.art_no "
				+ "inner join allfile on artist.f_no = allfile.f_no " + "where mem_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setF_name(rs.getString("f_name"));
					vo.setArt_name(rs.getString("art_name"));
					mvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return mvo;
	}

	public List<MainVO> genreFirst(Connection conn) {
		List<MainVO> gvo = new ArrayList<MainVO>();
		String sql = "select * from (select rownum rnum, m.* " + "from (select genre.*, f_name from genre, allfile "
				+ "where genre.f_no = allfile.f_no) m) where rnum between 1 and 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setGn_name(rs.getString("gn_name"));
					vo.setF_name(rs.getString("f_name"));
					gvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return gvo;
	}

	public List<MainVO> genreSecond(Connection conn) {
		List<MainVO> gvo = new ArrayList<MainVO>();
		String sql = "select * from (select rownum rnum, m.* " + "from (select genre.*, f_name from genre, allfile "
				+ "where genre.f_no = allfile.f_no) m) where rnum between 6 and 10";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setGn_name(rs.getString("gn_name"));
					vo.setF_name(rs.getString("f_name"));
					gvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return gvo;
	}

	public List<MainVO> genreThird(Connection conn) {
		List<MainVO> gvo = new ArrayList<MainVO>();
		String sql = "select * from (select rownum rnum, m.* " + "from (select genre.*, f_name from genre, allfile "
				+ "where genre.f_no = allfile.f_no) m) where rnum between 11 and 15";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setGn_name(rs.getString("gn_name"));
					vo.setF_name(rs.getString("f_name"));
					gvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return gvo;
	}

	public List<MainVO> genreFourth(Connection conn) {
		List<MainVO> gvo = new ArrayList<MainVO>();
		String sql = "select * from (select rownum rnum, m.* " + "from (select genre.*, f_name from genre, allfile "
				+ "where genre.f_no = allfile.f_no) m) where rnum between 16 and 20";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setGn_name(rs.getString("gn_name"));
					vo.setF_name(rs.getString("f_name"));
					gvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return gvo;
	}

	public List<MainVO> genreFifth(Connection conn) {
		List<MainVO> gvo = new ArrayList<MainVO>();
		String sql = "select * from (select rownum rnum, m.* " + "from (select genre.*, f_name from genre, allfile "
				+ "where genre.f_no = allfile.f_no) m) where rnum between 21 and 22";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setGn_name(rs.getString("gn_name"));
					vo.setF_name(rs.getString("f_name"));
					gvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return gvo;
	}

	public int addMyPlayList(Connection conn, String mem_id, String mu_no) {
		int result = 0;
		String sql = "insert into musichistory (mem_id, mu_no) values (?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mu_no);
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("플레이리스트 추가 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

//	public List<MainVO> firstMyMusic(Connection conn, String mem_id) {
////		int result = 0;
//		List<MainVO> fvo = new ArrayList<MainVO>();
//		String sql = "select * from (select rownum rnum, m.* from "
//				+ "(select mem_id, mu_name, al_name, art_name, play_date, f_name, music.mu_no, mu_ly "
//				+ "from music join album on music.al_no = album.al_no "
//				+ "inner join artist on music.art_no = artist.art_no "
//				+ "inner join allfile on album.f_no = allfile.f_no "
//				+ "inner join musichistory on music.mu_no = musichistory.mu_no "
//				+ "where mem_id=? and play_now='Y' order by play_date desc) m) where rnum=1";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				do {
//					MainVO vo = new MainVO();
//					vo.setMu_no(rs.getString("mu_no"));
//					vo.setMem_id(rs.getString("mem_id"));
//					fvo.add(vo);
//					System.out.println("성공");
//				} while (rs.next());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("firstMyMusic DAO 실패");
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		System.out.println("리턴값 firstMyMusic");
//		return fvo;
//	}

	public List<MainVO> showCurrmusic(Connection conn, String mem_id) {
		List<MainVO> mvo = new ArrayList<MainVO>();
		String sql = "select currmusic.*, mu_name, art_name, al_name, album.al_no, artist.art_no, a.f_name musicfile, b.f_name albumfile from currmusic " + 
				"				join music on currmusic.mu_no=music.mu_no " + 
				"				inner join artist on music.art_no=artist.art_no " + 
				"				inner join album on music.al_no=album.al_no inner join allfile a on music.f_no = a.f_no inner join allfile b on album.f_no = b.f_no where mem_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainVO vo = new MainVO();
					vo.setMusicfile(rs.getString("musicfile"));
					vo.setAlbumfile(rs.getString("albumfile"));
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMem_id(rs.getString("mem_id"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setAl_name(rs.getString("al_name"));
					mvo.add(vo);
					System.out.println("showCurrmusic 성공!");
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("showCurrmusic fail");
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("showCurrmusic return");
		return mvo;
	}

	public int updateCurrmusic(Connection conn, String mem_id, String mu_no) {
		int result = 0;
		String sql = "update currmusic set mu_no=? where mem_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mu_no);
			pstmt.setString(2, mem_id);
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("currmusic update 실패 in dao");
			} else {
				System.out.println("currmusic update success in dao");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
