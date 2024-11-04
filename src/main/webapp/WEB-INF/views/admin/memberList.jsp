<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<Style>
			body {
			  margin: 0;
			  padding: 0;
			  color: #fff;
			  font-family: 'Open Sans', Helvetica, sans-serif;
			  box-sizing: border-box;
			}
			
			.grid-container {
			  display: grid;
			  grid-template-columns: 240px 1fr;
			  grid-template-rows: 50px 1fr 50px;
			  grid-template-areas: 
			    "sidenav header" 
			    "sidenav main" 
			    "sidenav footer";
			  height: 100vh;
			}
			
			.menu-icon {
			  position: fixed;
			  top: 5px;
			  left: 10px;
			  display: flex;
			  align-items: center;
			  justify-content: center;
			  background-color: #DADAE3;
			  border-radius: 50%;
			  z-index: 1;
			  cursor: pointer;
			  padding: 12px;
			}
			
			.header {
			  grid-area: header;
			  display: flex;
			  align-items: center;
			  justify-content: space-between;
			  padding: 0 16px;
			  background-color: #648ca6;
			}
			
			.sidenav {
			  grid-area: sidenav;
			  display: flex;
			  flex-direction: column;
			  width: 240px;
			  overflow-y: auto;
			  background-color: #394263;
			  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.16), 0 0 0 1px rgba(0, 0, 0, 0.08);
			}
			
			.sidenav__list {
			  margin-top: 85px;
			  padding: 0;
			  list-style-type: none;
			}
			
			.sidenav__list-item {
			  padding: 20px 40px;
			  color: #ddd;
			  cursor: pointer;
			}
			
			.sidenav__list-item:hover {
			  background-color: rgba(255, 255, 255, 0.2);
			}
			
			.main {
			  grid-area: main;
			  background-color: #8fd4d9;
			  padding: 20px;
			}
			
			.card {
			  background-color: #82bef6;
			  padding: 24px;
			  margin-bottom: 20px;
			  text-align: center;
			}
			
			.footer {
			  grid-area: footer;
			  display: flex;
			  align-items: center;
			  justify-content: space-between;
			  padding: 0 16px;
			  background-color: #648ca6;
			}
		</Style>
		<title></title>
    </head>

    <body>
	       <div class="grid-container">
			  <header class="header">
			    <div>MemberList</div>
			  </header>
			
			  <aside class="sidenav">
				  <c:import url="/WEB-INF/views/inc/adminSideNav.jsp"></c:import>
			  </aside>
			
			  <main class="main">
			    <div class="card">
			    	<table>
			    		<tr>
				    		<td>ID</td>
				    		<td>PW</td>
				    		<td>Birth</td>
				    		<td>active</td>
			    		</tr>
			    		<c:forEach var="m" items="${memberList}">
				    		<tr>
					    		<td>${m.memberId}</td>
					    		<td>${m.memberPw}</td>
					    		<td>${m.birth}</td>
					    		<td>
					    			${m.active}
					    			<a href="${pageContext.request.contextPath}/admin/editMemberActivity?memberId=${m.memberId}&active=${m.active}">
					    				<c:if test="${m.active==1}">Disable</c:if>
					    				<c:if test="${m.active==2}">Activate</c:if>
					    			</a>
				    			</td>
				    		</tr>
			    		</c:forEach>
			    	</table>
			    </div>
			  </main>
			
			  <footer class="footer">
				  <c:import url="/WEB-INF/views/inc/footer.jsp"></c:import>
			  </footer>
			</div>
    </body>
</html>