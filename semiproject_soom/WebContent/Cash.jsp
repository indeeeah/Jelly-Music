<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/main_login.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cash</title>
<script src="http://code.jquery.com/jquery-3.4.0.js"></script>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap')
	;
</style>
            <style>
            @charset "UTF-8";

/* 초기화 */

@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Raleway:wght@800&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Roboto+Mono:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lemon&family=Lilita+One&family=Luckiest+Guy&family=Paytone+One&family=Sniglet:wght@800&family=Work+Sans:wght@900&display=swap');
body {
    font-family: 'Nanum Gothic', sans-serif;
    width: 100%;
    height: 100%;
    background-color: rgb(22, 25, 41);
}

a {
    text-decoration: none;
    color: rgb(244, 244, 244);
    cursor: pointer;
}


/* fix_nav */

#fix_side {
    width: 259px;
    height: 100%;
    background-color: rgb(20, 23, 38);
    position: fixed;
    float: left;
}

#fix_logo {
    width: 209px;
    height: 60px;
    top: 0px;
    margin-top: 30px;
    margin-left: 25px;
}

#fix_logo_title {
    position: absolute;
    font-family: 'Lemon', cursive;
    font-size: 23px;
    color: rgb(244, 244, 244);
    line-height: 45px;
    right: 25px;
}

#fix_logo_img {
    position: absolute;
    width: 45px;
    height: 45px;
    border: 2px solid rgb(74, 254, 0);
    border-radius: 50%;
    background-color: rgb(74, 254, 0);
    float: left;
}

#fix_user {
    width: 259px;
    height: 60px;
    text-align: left;
}

#fix_user>a {
    margin-right: 30px;
    line-height: 60px;
    left: 0px;
    font-size: 16px;
    margin-left: 10px;
    font-weight: bold
}

#fix_prof {
    width: 30px;
    height: 60px;
    float: left;
    margin-left: 32px;
}

#fix_side_menu {
    overflow: hidden;
    margin-top: 11px;
    margin-left: 25px;
    width: 209px;
}

#fix_side_menu>div>input[type="radio"] {
    display: none;
}

.fix_each {
    box-sizing: border-box;
    border: 1px solid rgb(20, 23, 38);
    width: 209px;
    height: 35px;
    padding-left: 10px;
    margin-bottom: 10px;
}

.fix_menu_icon {
    width: 20px;
    height: 35px;
}

.fix_each:hover {
    box-sizing: border-box;
    border: 1px solid rgb(74, 254, 0);
    border-radius: 6px;
}

.fix_each_menu {
    width: 164px;
    color: rgb(244, 244, 244);
    float: right;
    line-height: 35px;
}

.fix_each_menu:hover {
    color: rgb(168, 168, 169);
}

.fix_each:hover>.fix_each_menu {
    width: 164px;
}

#fix_side_menu>div>ul {
    display: none;
    width: 209px;
    margin-top: -10px;
    margin-bottom: 7px;
}

#fix_side_menu>div>ul>li {
    height: 30px;
}

#fix_side_menu>div>ul>li>a {
    line-height: 32px;
    margin-left: 45px;
    font-size: 15px;
}

#fix_side_menu>div>ul>li>a:hover {
    color: rgb(168, 168, 169);
}

nav>#fix_side_menu>div>input:nth-of-type(1):checked~.fix_each:nth-of-type(1) {
    box-sizing: border-box;
    border: 1px solid rgb(74, 254, 0);
    border-radius: 6px;
}

nav>#fix_side_menu>div>input:nth-of-type(2):checked~.fix_each:nth-of-type(2) {
    box-sizing: border-box;
    border: 1px solid rgb(74, 254, 0);
    border-radius: 6px;
}

nav>#fix_side_menu>div>input:nth-of-type(5):checked~.fix_each:nth-of-type(5) {
    box-sizing: border-box;
    border: 1px solid rgb(74, 254, 0);
    border-radius: 6px;
}

nav>#fix_side_menu>div>input:nth-of-type(1):checked~.fix_each:nth-of-type(1)+ul {
    display: block;
}

nav>#fix_side_menu>div>input:nth-of-type(2):checked~.fix_each:nth-of-type(2)+ul {
    display: block;
}

nav>#fix_side_menu>div>input:nth-of-type(5):checked~.fix_each:nth-of-type(5)+ul {
    display: block;
}

.fix_btn {
    width: 209px;
    height: 40px;
    bottom: 30px;
    margin-left: 25px;
    position: absolute;
}

.fix_player_btn {
    width: 209px;
    height: 40px;
    border: none;
    outline: none;
    background-color: rgb(74, 254, 0);
    font-weight: bold;
    border-radius: 40px;
    cursor: pointer;
    text-shadow: 0 0 10px rgb(74, 254, 0);
    box-shadow: 0 0 25px 0 rgb(74, 254, 0), 0 20px 25px 0 rgba(0, 0, 0, 0.2);
}

.fix_player_btn:hover {
    box-sizing: border-box;
    border: 2px solid rgb(74, 254, 0);
    background-color: rgb(20, 23, 38);
    color: rgb(244, 244, 244);
    text-shadow: 0 0 10px rgb(74, 254, 0);
    box-shadow: 0 0 25px 0 rgb(74, 254, 0), 0 20px 25px 0 rgba(0, 0, 0, 0.2);
}


/* fix_header */

.fix_header {
    height: 90px;
    width: calc(100% - 259px);
    box-shadow: 0px 8px 2px rgba(0, 0, 0, 0.2), 0 6px 20px rgba(0, 0, 0, 0.19);
    background-color: rgb(23, 26, 40);
    position: absolute;
    float: right;
    right: 0px;
}

.fix_search {
    position: absolute;
    top: 20px;
    right: 40px;
    width: 45px;
    height: 45px;
    border-radius: 50%;
    transition: all 1s;
    z-index: 4;
    box-shadow: 0 0 25px 0 rgba(0, 0, 0, 0.4);
}

.fix_search:hover {
    cursor: pointer;
}

.fix_search::before {
    content: "";
    position: absolute;
    margin: auto;
    top: 22px;
    right: 0;
    bottom: 0;
    left: 22px;
    width: 12px;
    height: 2px;
    background: rgb(244, 244, 244);
    transform: rotate(45deg);
    transition: all .5s;
}

.fix_search::after {
    content: "";
    position: absolute;
    margin: auto;
    top: -5px;
    right: 0;
    bottom: 0;
    left: -5px;
    width: 25px;
    height: 25px;
    border-radius: 50%;
    border: 4px solid rgb(244, 244, 244);
    transition: all .5s;
}

.fix_searchbx {
    position: absolute;
    top: 30px;
    right: 40px;
    width: 25px;
    height: 25px;
    outline: none;
    border: none;
    background: rgb(74, 254, 0);
    color: black;
    text-shadow: 0 0 10px rgb(74, 254, 0);
    padding: 0 80px 0 20px;
    border-radius: 30px;
    box-shadow: 0 0 25px 0 rgb(74, 254, 0), 0 20px 25px 0 rgba(0, 0, 0, 0.2);
    transition: all 1s;
    opacity: 0;
    z-index: 5;
    font-weight: bolder;
    letter-spacing: 0.1em;
}

.fix_searchbx:hover {
    cursor: pointer;
}

.fix_searchbx:focus {
    width: 300px;
    opacity: 1;
    cursor: text;
}

.fix_searchbx:focus~.fix_search {
    background: #151515;
    z-index: 6;
}

.fix_searchbx:focus~.fix_search::before {
    top: 0;
    left: 0;
    width: 25px;
}

.fix_searchbx:focus~.fix_search::after {
    top: 0;
    left: 0;
    width: 25px;
    height: 2px;
    border: none;
    background: rgb(244, 244, 244);
    border-radius: 0%;
    transform: rotate(-45deg);
}

.fix_searchbx:focus::placeholder {
    color: rgb(244, 244, 244);
    opacity: 0.5;
    font-weight: bolder;
}

.fix_realtime {
    height: 90px;
    width: 150px;
    float: right;
    margin-right: 100px;
}

.fix_rt_div {
    position: absolute;
    bottom: 40px;
    right: 100px;
    width: 150px;
    transition: all 1s;
    z-index: 10;
}

#fix_m_scroller {
    height: 15px;
    overflow: hidden;
    position: relative;
}

.tri {
    width: 0px;
    height: 0px;
    margin-top: 5px;
    border-top: 5px solid none;
    border-bottom: 5px solid red;
    border-right: 5px solid transparent;
    border-left: 5px solid transparent;
    float: right;
}

#fix_m_scroller .fix_item {
    display: block;
    animation: scroll 10s infinite;
}

#rtdrop {
    position: absolute;
    right: 100px;
    width: 200px;
    color: rgb(244, 244, 244);
    box-sizing: border-box;
    border: 1px solid rgb(74, 254, 0);
    border-radius: 15px;
    background-color: rgb(23, 26, 40);
    top: 60px;
    font-size: 12px;
    display: none;
    overflow: hidden;
    z-index: 6;
}

#rtdrop:hover {
    display: block;
}

#rtdrop>tbody {
    width: 200px;
}

#rtdrop>tbody>tr>td {
    padding: 10px;
}

#rtdrop>tr>td {
    border: 1px;
}

.fix_realtime:hover~#rtdrop {
    display: block;
}

.fix_searchbx:focus~#rtdrop {
    right: 460px;
}

.rt_link {
    font-size: 15px;
    background: transparent;
    text-decoration: none;
    color: rgb(244, 244, 244);
}

.rt_link:hover {
    animation-play-state: paused;
    text-decoration: underline;
}

.fix_item:hover {
    animation-play-state: paused;
}

.fix_searchbx:focus~.fix_realtime>.fix_rt_div {
    right: 460px;
}

@keyframes scroll {
    0.0% {
        transform: translateY(0px)
    }
    10% {
        transform: translateY(0px)
    }
    20% {
        transform: translateY(-16px)
    }
    30% {
        transform: translateY(-32px)
    }
    40% {
        transform: translateY(-48px)
    }
    50% {
        transform: translateY(-64px)
    }
    60% {
        transform: translateY(-80px)
    }
    70% {
        transform: translateY(-96px)
    }
    80% {
        transform: translateY(-112px)
    }
    90% {
        transform: translateY(-128px)
    }
    100% {
        transform: translateY(-144px)
    }
}



/*fix_footer*/

#fix_footer {
    position: relative;
    height: 100px;
    width: calc(100% - 259px);
    bottom: 0px;
    font-size: 11px;
    color: rgb(244, 244, 244);
    float: right;
    right: 0px;
}

#fix_fline {
    border: 0;
    height: 1px;
    background-color: rgb(168, 168, 169);
}

#fix_ft {
    margin-top: 21px;
}

.fix_fc {
    margin-left: 40px;
    margin-top: 5px;
}

#fix_copy {
    float: left;
}

#fix_national {
    float: right;
    margin-right: 40px;
}

#fix_link {
    width: 90%;
    float: left;
}

#fix_link>a {
    color: rgb(244, 244, 244);
}

#fix_info {
    float: left;
}


/* main content when login+unlogin */

.main_content {
    margin-top: 90px;
    width: 100%;
    height: 800px;
    float: right;
}

.main_content>input[type="radio"] {
    position: absolute;
    right: 120px;
    top: 205px;
    border: none;
    opacity: 0;
    z-index: 10;
    cursor: pointer;
}

#m2 {
    top: 235px;
}

#m3 {
    top: 265px;
}

.mt {
    font-family: 'Raleway', sans-serif;
    position: absolute;
    top: 170px;
    right: 170px;
    color: rgb(244, 244, 244);
    font-size: 70px;
    text-align: right;
}

.main_title_01 {
    display: none;
}

.cus_radio {
    position: absolute;
    right: 120px;
    top: 205px;
    width: 15px;
    height: 15px;
    box-sizing: border-box;
    border: 1px solid rgb(244, 244, 244);
    border-radius: 50%;
    z-index: -1;
    opacity: 0.3;
}

#for_m2 {
    top: 235px;
}

#for_m3 {
    top: 265px;
}

.main_content>input:nth-of-type(1):hover~span:nth-of-type(1) {
    background-color: rgb(244, 244, 244);
    border: none;
    width: 17px;
    height: 17px;
    right: 119px;
    top: 204px;
    opacity: 1;
}

.main_content>input:nth-of-type(2):hover~span:nth-of-type(2) {
    background-color: rgb(244, 244, 244);
    border: none;
    width: 17px;
    height: 17px;
    right: 119px;
    top: 234px;
    opacity: 1;
}

.main_content>input:nth-of-type(3):hover~span:nth-of-type(3) {
    background-color: rgb(244, 244, 244);
    border: none;
    width: 17px;
    height: 17px;
    right: 119px;
    top: 264px;
    opacity: 1;
}

.main_content>input:nth-of-type(1):checked~span:nth-of-type(1) {
    background-color: rgb(244, 244, 244);
    border: none;
    width: 17px;
    height: 17px;
    right: 119px;
    top: 204px;
    opacity: 1;
}

.main_content>input:nth-of-type(2):checked~span:nth-of-type(2) {
    background-color: rgb(244, 244, 244);
    border: none;
    width: 17px;
    height: 17px;
    right: 119px;
    top: 234px;
    opacity: 1;
}

.main_content>input:nth-of-type(3):checked~span:nth-of-type(3) {
    background-color: rgb(244, 244, 244);
    border: none;
    width: 17px;
    height: 17px;
    right: 119px;
    top: 264px;
    opacity: 1;
}

.main_content>input:nth-of-type(1):checked~.mt>label:nth-of-type(1) {
    display: block;
}

.main_content>input:nth-of-type(2):checked~.mt>label:nth-of-type(2) {
    display: block;
}

.main_content>input:nth-of-type(3):checked~.mt>label:nth-of-type(3) {
    display: block;
}

#title_p {
    position: absolute;
    width: 80px;
    height: 80px;
    right: 230px;
    top: 350px;
    border: 0px;
    color: rgb(244, 244, 244);
    border: 3px solid rgb(244, 244, 244);
    border-radius: 50%;
    transition: all 1s;
}

#title_p:hover {
    right: 190px;
    width: 160px;
    height: 40px;
    border-radius: 30px;
    top: 370px;
    background-color: rgb(74, 254, 0);
    border: 3px solid rgb(74, 254, 0);
    text-shadow: 0 0 10px rgb(74, 254, 0);
    box-shadow: 0 0 25px 0 rgb(74, 254, 0), 0 20px 25px 0 rgba(0, 0, 0, 0.2);
}

#title_p:hover>a {
    margin-left: 56.61px;
    color: black;
    margin-top: 10px;
}

#title_p>a {
    position: absolute;
    font-weight: bold;
    font-size: 20px;
    margin-left: 16.61px;
    margin-top: 30px;
    cursor: pointer;
    z-index: 2;
    transition: all 1s;
}

#title_tri {
    position: absolute;
    top: 372px;
    right: 258px;
    border-top: 10px solid transparent;
    border-bottom: 10px solid transparent;
    border-right: 15px solid rgb(244, 244, 244);
}

.more {
    outline: none;
    border: none;
    border: 2px solid rgb(74, 254, 0);
    font-weight: bold;
    width: 60px;
    height: 30px;
    border-radius: 20px;
    cursor: pointer;
    background-color: transparent;
    color: rgb(244, 244, 244);
    box-sizing: border-box;
}

.more:hover {
    background-color: rgb(74, 254, 0);
    border: none;
    color: black;
}

.for_you {
    position: relative;
    color: rgb(244, 244, 244);
    width: 1200px;
    height: 100%;
    left: 379px;
}

.for_you>#ct1 {
    position: absolute;
    top: 500px;
}

.for_you>.more {
    position: absolute;
    top: 500px;
    right: 0;
}

.for_you>.fytb>tbody {
    position: absolute;
    width: 100%;
    top: 540px;
}

.for_you>.fytb>tbody>tr>td {
    padding-right: 25px;
}

.for_you>.fytb>tbody>tr>td:nth-of-type(5) {
    padding: 0px;
}

.album {
    width: 220px;
    height: 220px;
    background-color: aliceblue;
    border-radius: 10px;
    cursor: pointer;
}

#art_01 {
    left: 379px;
}

#art_05 {
    right: 120px;
}

.album_title {
    padding-top: 10px;
}

.album_title>a>h1 {
    font-weight: bold;
}

.maylike {
    position: relative;
    color: rgb(244, 244, 244);
    width: 1200px;
    height: 299px;
    left: 379px;
}

.maylike>#ct2 {
    position: absolute;
    top: 70px;
}

.maylike>.mltb>tbody {
    position: absolute;
    width: 100%;
    top: 110px;
}

.maylike>.mltb>tbody>tr>td {
    padding-right: 48px;
}

.maylike>.mltb>tbody>tr>td:nth-of-type(6) {
    padding: 0px;
}

.arti_art {
    width: 160px;
    height: 160px;
    border-radius: 50%;
    background-color: rgb(244, 244, 244);
}

.ml_arti {
    padding-top: 10px;
    text-align: center;
}

.latelyls {
    position: relative;
    color: rgb(244, 244, 244);
    width: 1200px;
    height: 372px;
    left: 379px;
}

.latelyls>#ct3 {
    position: absolute;
    top: 70px;
}

.latelyls>.more {
    position: absolute;
    top: 70px;
    right: 0;
}

.latelyls>.ltltb>tbody {
    position: absolute;
    width: 100%;
    top: 110px;
}

.latelyls>.ltltb>tbody>tr>td {
    padding-right: 25px;
}

.latelyls>.ltltb>tbody>tr>td:nth-of-type(5) {
    padding: 0px;
}

.top100 {
    position: relative;
    color: rgb(244, 244, 244);
    width: 1200px;
    height: 462px;
    left: 379px;
}

.top100>#ct4 {
    position: absolute;
    top: 70px;
    font-family: 'Raleway', sans-serif;
    font-size: 35px;
}

.top100>.more {
    position: absolute;
    top: 80px;
    right: 0;
}

.top100>.up {
    position: absolute;
    top: 110px;
    width: 100%;
    border: none;
    height: 0.5px;
    background-color: rgb(244, 244, 244);
}

.top100>div {
    position: absolute;
    width: 1150px;
    height: 280px;
    top: 150px;
    left: 25px;
}

.top100_each_left {
    position: absolute;
    width: 555px;
    height: 280px;
}

.top100_each_right {
    position: absolute;
    width: 555px;
    height: 280px;
    right: 0px;
}

.top100_each_l {
    position: relative;
    width: 555px;
    height: 56px;
    border-top: 1px solid rgb(244, 244, 244);
}

.top100_each_r {
    position: relative;
    width: 555px;
    height: 56px;
    right: 0px;
    border-top: 1px solid rgb(244, 244, 244);
}

.top100_each_l:nth-of-type(5) {
    border-bottom: 1px solid rgb(244, 244, 244);
}

.top100_each_r:nth-of-type(5) {
    border-bottom: 1px solid rgb(244, 244, 244);
}

.top100_each_l>a>.top100_tri {
    display: none;
    position: absolute;
    top: 18px;
    left: 15px;
    border-top: 10px solid transparent;
    border-bottom: 10px solid transparent;
    border-left: 15px solid rgb(74, 254, 0);
}

.top100_each_r>a>.top100_tri {
    display: none;
    position: absolute;
    top: 18px;
    left: 15px;
    border-top: 10px solid transparent;
    border-bottom: 10px solid transparent;
    border-left: 15px solid rgb(74, 254, 0);
}

.top100_each_l:hover>a>.top100_tri {
    display: block;
}

.top100_each_r:hover>a>.top100_tri {
    display: block;
}

.t100_l_album {
    position: absolute;
    width: 40px;
    height: 40px;
    top: 8px;
    background-color: rgb(244, 244, 244);
}

.t100_r_album {
    position: absolute;
    width: 40px;
    height: 40px;
    top: 8px;
    background-color: rgb(244, 244, 244);
}

.top100_each_l>div {
    position: absolute;
    width: 495px;
    height: 40px;
    top: 8px;
    right: 0px;
    padding-top: 10.5px;
}

.top100_each_r>div {
    position: absolute;
    width: 495px;
    height: 40px;
    top: 8px;
    right: 0px;
    padding-top: 10.5px;
}

.t100_title {
    position: absolute;
    width: 310px;
    height: 40px;
}

.t100_name {
    position: absolute;
    width: 165px;
    height: 40px;
    right: 0px;
}

.top100>.down {
    position: absolute;
    top: 460px;
    width: 100%;
    border: none;
    height: 0.5px;
    background-color: rgb(244, 244, 244);
}

.newrl {
    position: relative;
    color: rgb(244, 244, 244);
    width: 1200px;
    height: 457px;
    left: 379px;
}

.newrl>#ct5 {
    position: absolute;
    top: 70px;
    font-family: 'Raleway', sans-serif;
    font-size: 35px;
}

.newrl>.more {
    position: absolute;
    top: 80px;
    right: 0;
}

.newrl>.up {
    position: absolute;
    top: 110px;
    width: 100%;
    border: none;
    height: 0.5px;
    background-color: rgb(244, 244, 244);
}

.newrltbl>tbody {
    position: absolute;
    width: 100%;
    top: 158px;
}

.newrltbl>tbody>tr>td {
    padding-right: 25px;
}

.newrltbl>tbody>tr>td:nth-of-type(5) {
    padding-right: 0;
}

.newrl>.down {
    position: absolute;
    top: 448px;
    width: 100%;
    border: none;
    height: 0.5px;
    background-color: rgb(244, 244, 244);
}

            </style>
            <style>
                .main_content {
                    background: linear-gradient(to right, rgba(22, 25, 41, 0) 30%, rgba(22, 25, 41, 0.25) 55%, rgba(22, 25, 41, 0.5) 70%, rgba(22, 25, 41, 0.75) 75%, rgba(22, 25, 41, 1) 100%),
                    linear-gradient(to bottom, rgba(22, 25, 41, 0) 80%, rgba(22, 25, 41, 0.25) 85%, rgba(22, 25, 41, 0.5) 90%, rgba(22, 25, 41, 0.75) 95%, rgba(22, 25, 41, 1) 100%),
                    url('${pageContext.request.contextPath}/image/hostile-886034.jpg');
                    background-size: calc(100% - 259px);
                    background-repeat: no-repeat;
                }
                
                #fix_logo_img {
                    background-image: url('${pageContext.request.contextPath}/image/logo.svg');
                    background-size: 45px;
                }
                
                #j_img {
                    background-image: url('${pageContext.request.contextPath}/image/logo.svg');
                    background-size: 100px;
                }
            </style>
</head>
      <body>
            <input type="hidden" id="mem_id" value="${mem_id }" name="mem_id">
            <nav id="fix_side">
                <div id="fix_logo">
                    <div id="fix_logo_img"></div>
                    <a href="mainServlet" id="fix_logo_title">Jelly Music</a>
                </div>
                <div id="fix_user">
                    <img src="${pageContext.request.contextPath}/image/005-user.svg" id="fix_prof">
                    <c:if test="${not empty himem }">
                        <c:forEach items="${himem }" var="v" varStatus="s">
                            <a href="#">Hello, ${v.mem_aka }</a>
                        </c:forEach>
                    </c:if>
                </div>
                <div id="fix_side_menu">
                    <div>
                        <input type="radio" name="fix_drp" id="login"> <input type="radio" name="fix_drp" id="song"> <input type="radio" name="fix_drp" id="myplaylist"> <input type="radio" name="fix_drp" id="recommend"> <input type="radio" name="fix_drp"
                            id="help"> <input type="radio" name="fix_drp" id="membership">
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/007-settings.svg" class="fix_menu_icon"> <label for="login" class="fix_each_menu">마이페이지</label>
                        </div>
                        <ul>
                            <li><a href="#">구매내역</a></li>
                            <li><a href="#">보관함</a></li>
                            <li><a href="#">계정설정</a></li>
                            <li><a href="#">로그아웃</a></li>
                        </ul>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/003-play-button.svg" class="fix_menu_icon"> <label for="song" class="fix_each_menu" onclick="location.href='mainListCtrl.do';">노래</label>
                        </div>
                        <ul>
                            <li><a href="#">실시간 차트</a></li>
                            <li><a href="#">하트 차트</a></li>
                            <li><a href="#">장르</a></li>
                            <li><a href="#">무드별</a></li>
                        </ul>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/002-music-1.svg" class="fix_menu_icon"> <label for="myplaylist" class="fix_each_menu">마이플레이리스트</label>
                        </div>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/001-music.svg" class="fix_menu_icon"> <label for="recommend" class="fix_each_menu">나만의 추천</label>
                        </div>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/008-internet.svg" class="fix_menu_icon"> <label for="help" class="fix_each_menu">고객지원센터</label>
                        </div>
                        <ul>
                            <li><a href="#">공지사항</a></li>
                            <li><a href="#">Q&A</a></li>
                            <li><a href="#">자주하는 질문</a></li>
                            <li><a href="#">로그아웃</a></li>
                        </ul>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/006-star.svg" class="fix_menu_icon"> <label for="membership" class="fix_each_menu">이용권구매</label>
                        </div>
                    </div>
                </div>
                <div class="fix_btn">
                    <c:if test="${not empty scm }">
                        <c:forEach items="${scm }" var="v" varStatus="s" end="0">
                            <input type="hidden" name="mu_no" value=${v.mu_no }>
                            <input type="hidden" id="mem_id" name="mem_id" value=${v.mem_id }>
                            <button class="fix_player_btn" onclick="window.open('<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}','','width=1200,height=720')">Player</button>
                        </c:forEach>
                    </c:if>
                </div>
            </nav>
            <header class="fix_header">
                <input type="text" class="fix_searchbx">
                <div class="fix_search"></div>
                <div class="fix_realtime">
                    <div class="fix_rt_div">
                        <div id='fix_m_scroller'>
                            <c:if test="${not empty searlist}">
                                <c:forEach items="${searlist }" var="vo" varStatus="s">
                                    <c:set var="sum" value="${sum+1 }" />
                                    <div class='fix_item'>
                                        <a class='rt_link' href='#'>${sum }. ${vo.sear_word }
									<div class="tri"></div>
								</a>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </div>
                <table id="rtdrop">
                    <c:if test="${not empty searlist}">
                        <c:forEach items="${searlist }" var="vo" varStatus="s">
                            <c:set var="sum2" value="${sum2+1 }" />
                            <tr>
                                <td width="10%">${sum2 }.</td>
                                <td width="80%"><a href="#">${vo.sear_word }</a></td>
                                <td width="10%">
                                    <div class="tri"></div>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </header>
 
	<div id="container" class="container">
		<div id="content" class="content">
		<form id="frm">
		현재 소지한 캐쉬는 ${cs_left}원 입니다.
		 <input type=hidden name="cs_left"
			id="cs_left" value="${cs_left}">
			<%
			String price = "0";   // 한 곡당 가격 700원 이 화면에서는 거의 0으로 세팅될 것임.
			if(request.getParameter("price") != null) {
				price = request.getParameter("price");
			}
			%> 
		<input type=hidden name="cs_price"
			id="cs_price" value="<%=price%>"> 
		<label for="priceType1">10000원</label> <input type="radio" name="priceType"
			id="priceType1" class="priceType" value="10000" checked> <br>
		<label for="priceType2">20000원</label> <input type="radio"
			name="priceType" id="priceType2" class="priceType" value="20000"> <br> 
		<label for="priceType3">30000원</label> <input type="radio"
			name="priceType" id="priceType3" class="priceType" value="30000">

		<br> <input type="button" value="캐쉬충전" onclick="goSubmit();">
	</form>
		</div>
	</div>
                <footer id="fix_footer">
                    <hr id="fix_fline">
                    <div id="fix_ft">
                        <div id="fix_copy" class="fix_fc">Copyright ⓒ 2020 Jelly. All rights reserved.</div>
                        <div id="fix_national" class="fix_fc">Republic of Korea</div>
                        <div id="fix_link" class="fix_fc">
                            <a href="#">이용약관</a> | <a href="#">개인정보처리방침</a> | <a href="#">고객센터</a> | <a href="#">이메일주소무단수집거부</a>
                        </div>
                        <div id="fix_info" class="fix_fc">제작자 : 김경태 김수민 곽은지 김지용 장재혁</div>
                    </div>
                </footer>
            
            <script>
                $(".tri_con").click(function() {
                    var showTvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showTvalue);
                    console.log(showmemId);

                    $.ajax({
                        type: "POST",
                        url: "mainToPlayListSrv",
                        data: {
                            mem_id: showmemId,
                            mu_no: showTvalue
                        },
                        success: function(resulttr) {

                        }
                    });
                });

                $(".tri_con").click(function() {
                    var showTvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showTvalue + "update");
                    console.log(showmemId);

                    $.ajax({
                        type: "POST",
                        url: "updateCurrmusicServlet",
                        data: {
                            mem_id: showmemId,
                            mu_no: showTvalue
                        },
                        success: function(resultcm) {
                            console.log("업뎃 성공!");
                        }
                    });
                });

                $(".for_you_con").click(function() {
                     var showFvalue = $(this).next().val();
                     var showmemId = $("#mem_id").val();
                     console.log(showFvalue);
                     console.log(showmemId);


                     $.ajax({
                         type: "POST",
                         url: "mainToPlayListSrv",
                         data: {
                             mem_id: showmemId,
                             mu_no: showFvalue
                         },
                         success: function(resultfy) {

                         }
                     });
                 });

                $(".for_you_con").click(function() {
                    var showFvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showFvalue);
                    console.log(showmemId);


                    $.ajax({
                        type: "POST",
                        url: "updateCurrmusicServlet",
                        data: {
                            mem_id: showmemId,
                            mu_no: showFvalue
                        },
                        success: function(resultcm) {

                        }
                    });
                });

                $(".lpm_con").click(function() {
                    var showLvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showLvalue);
                    console.log(showmemId);


                    $.ajax({
                        type: "POST",
                        url: "mainToPlayListSrv",
                        data: {
                            mem_id: showmemId,
                            mu_no: showLvalue
                        },
                        success: function(resultlp) {

                        }
                    });
                });

                $(".lpm_con").click(function() {
                    var showLvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showLvalue);
                    console.log(showmemId);


                    $.ajax({
                        type: "POST",
                        url: "updateCurrmusicServlet",
                        data: {
                            mem_id: showmemId,
                            mu_no: showLvalue
                        },
                        success: function(resultcm) {

                        }
                    });
                });

                $(".newrl_con").click(function() {
                     var showNvalue = $(this).next().val();
                     var showmemId = $("#mem_id").val();
                     console.log(showNvalue);
                     console.log(showmemId);

                     $.ajax({
                         type: "POST",
                         url: "mainToPlayListSrv",
                         data: {
                             mem_id: showmemId,
                             mu_no: showNvalue
                         },
                         success: function(resultnl) {

                         }
                     });
                 });

                $(".newrl_con").click(function() {
                    var showNvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showNvalue);
                    console.log(showmemId);

                    $.ajax({
                        type: "POST",
                        url: "updateCurrmusicServlet",
                        data: {
                            mem_id: showmemId,
                            mu_no: showNvalue
                        },
                        success: function(resultcm) {

                        }
                    });
                });
            </script>
        </body>

        </html>