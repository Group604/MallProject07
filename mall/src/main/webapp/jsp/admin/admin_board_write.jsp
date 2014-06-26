<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/admin_header.jsp" %>

  <!-- 관리자 메인내용 -->
  <div id="aMain_cont">
  <div id="BWrite_wrap">
  <h2 class="BWrite_title">관리자 게시판</h2>
  <form method="post" action="admin_board_write_ok.do"
  onsubmit="return w_check();">
  <table id="BWrite_t">
   <tr>
    <th>이름</th>
    <td>
    <input name="board_name" id="board_name" size="14"
    class="box" />
    </td>
   </tr>
   <tr>
    <th>제목</th>
    <td>
    <input name="board_title" id="board_title" size="38"
    class="box" />
    </td>
   </tr>
   <tr>
    <th>비밀번호</th>
    <td>
    <input type="password" name="board_pwd" id="board_pwd"
    size="14" class="box"/>
    </td>
   </tr>
   <tr>
    <th>내용</th>
    <td>
    <textarea name="board_cont" id="board_cont" rows="9"
    cols="37" class="box"></textarea>
    </td>
   </tr>
  </table>
  <div id="BWrite_menu">
   <input type="submit" value="저장" class="input_b" />
   <input type="reset" value="취소" class="input_b"
   onclick="$('#board_name').focus();" />
   <input type="button" value="목록" class="input_b"
   onclick="location='admin_board_list.do?page=${page}'" />
  </div>
  </form>
 </div>
  </div>

<%@ include file="../../include/admin_footer.jsp" %>