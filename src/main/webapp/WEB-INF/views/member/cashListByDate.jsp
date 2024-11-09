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
		    <div>CashList(DATE)</div>
		  </header>
		
		  <aside class="sidenav">
			  <c:import url="/WEB-INF/views/inc/memberSideNav.jsp"></c:import>
		  </aside>
		  
		  
			  <main class="main">
			  	 <%-- 일별 캐시리스트 --%>
		        <div class="card row d-flex justify-content-between">
		         	<%-- kind선택, rowPerPage 변경, ADD 버튼 --%>
				    <div class="d-flex justify-content-between">
					        <div class="dropdown">
			                <button id="" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
						        Kind
						    </button>
				            <ul class="dropdown-menu">
					            <li>
					            	<a class="dropdown-item" href="${pageContext.request.contextPath}/member/cashListByDate?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&rowPerPage=${cashListForm.rowPerPage}&kind=income">
					            		수입</a>
				            	</li>
								<li>
									<a class="dropdown-item" href="${pageContext.request.contextPath}/member/cashListByDate?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&rowPerPage=${cashListForm.rowPerPage}&kind=outcome">
										지출</a>
								</li>
							</ul>
						</div>
					    <span>
				            <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/member/cashListByDate?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&rowPerPage=5" class="mx-2">
				            	5Page
				            </a>
				            <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/member/cashListByDate?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&rowPerPage=10" class="mx-2">
				            	10Page
				            </a>
	
				            <a class="btn btn-primary justify-content-end" href="${pageContext.request.contextPath}/member/addCashData?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}">
				                ADD
				            </a>
	       			    </span>
				    </div>
				    <hr>
				    <%-- 리스트 --%>
			    	<table class="table table-striped">
			    		<thead class="table-dark">
				    		<tr>
				    			<th>CashDate</th>
				    			<th>Kind</th>
				    			<th>Money</th>
				    			<th>Memo</th>
				    			<th>CreateDate</th>
				    			<th>UpdateDate</th>
				    			<th>View</th>
				    			<th>Edit</th>
				    			<th>Delete</th>
				    		</tr>
			    		</thead>
			    		<c:choose>
			    			<c:when test="${cashListByDate.size() > 0}">
					    		<c:forEach var="c" items="${cashListByDate}">
						    		<tr>
						    			<td>${c.cashDate}</td>
						    			<td>${c.kind}</td>
						    			<td>${c.money}</td>
						    			<td>${c.memo}</td>
						    			<td>${c.createDate}</td>
						    			<td>${c.updateDate}</td>
						    			<td>
							    			<a class="btn btn-outline-primary"  href="${pageContext.request.contextPath}/member/cashListByDate?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&cashNo=${c.cashNo}">
								    	   		View
								    	   </a>
						    			</td>
						    			<td>
							    			<a class="btn btn-outline-primary"  href="${pageContext.request.contextPath}/member/editCashData?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&cashNo=${c.cashNo}">
								    	   		EDIT
								    	   </a>
						    			</td>
						    			<td>
						    				<a class="btn btn-outline-primary"  href="${pageContext.request.contextPath}/member/deleteCashData?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&cashNo=${c.cashNo}">
								    	   		DELETE
								    	    </a>
						    			</td>
						    			
						    		</tr>
			    				</c:forEach>
				    		</c:when>
				    		<c:otherwise>
				    			<tr>
				    				<td colspan="8">NO DATA</td>
				    			</tr>
				    		</c:otherwise>
			    		</c:choose>
			    	</table>
			    	<hr>
			    	<%-- 페이지 네비게이션 --%>
			    	<div class="col">
			    		<c:if test="${cashListForm.currentPage > 1}">
					    	<a class="btn btn-primary"  href="${pageContext.request.contextPath}/member/cashListByDate?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&currentPage=${cashListForm.currentPage-1}&rowPerPage=${cashListForm.rowPerPage}">
					    	   		◀
				    	    </a>
			    	    </c:if>
			    	    
			            <strong style="margin: 10px">[현재페이지 : ${cashListForm.currentPage}/ ${lastPage}]</strong>
			            <c:if test="${cashListForm.currentPage != lastPage}">
				            <a class="btn btn-primary"  href="${pageContext.request.contextPath}/member/cashListByDate?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&currentPage=${cashListForm.currentPage+1}&rowPerPage=${cashListForm.rowPerPage}">
				            		▶
				            </a>
			            </c:if>
		            </div>
			    </div>
			    
		  		<c:if test="${cashListForm.cashNo != null}">    
	         	<%-- 일별 가계부 상세보기 --%>
				    	<div class="row d-flex justify-content-between">
				    		<%-- String 정보 --%>
				    		<div class="card col-xl-4" style="min-width: 40%">
					         	<table class="table table-striped table-bordered">
       					    		<thead class="table-dark">
					    				<tr>
					    					<th>Category</th>
					    					<th>Content</th>
				    					</tr>
			    					</thead>
						    		<tr>
						    			<td>Kind</td>
										<td>${cash.kind}</td>					    			
					    			</tr>
						    		<tr>
						    			<td>money</td>
										<td>${cash.money}</td>					    			
					    			</tr>
						    		<tr>
						    			<td>memo</td>
										<td>${cash.memo}</td>					    			
					    			</tr>
						    		<tr>
						    			<td>createDate</td>
										<td>${cash.createDate}</td>					    			
					    			</tr>
						    		<tr>
						    			<td>updateDate</td>
										<td>${cash.updateDate}</td>					    			
					    			</tr>
				    			</table>
			    			</div>

			    			<%-- 영수증 사진 출력 --%>
			    			<div class="card col-xl-4" style="min-width: 59%">
			    				<c:if test="${empty fileList}">
			    					<div>No Content</div>
			    				</c:if>
			    				<c:if test="${!empty fileList}">
			    					<c:if test="${filmform.cashFileNo == null}">
										<div class="dropdown">
											<button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
										  		Select File
											</button>
											<c:forEach var="f" items="${fileList}">
												<ul class="dropdown-menu">
												  	<li>
												  		<a class="dropdown-item" href="${pageContext.request.contextPath}/member/cashListByDate?year=${cashListForm.year}&month=${cashListForm.month}&day=${cashListForm.day}&cashNo=${f.cashNo}&fileNo=${f.fileNo}">
												  			${f.fileName}.${f.ext}
												  		</a>
											  		</li>
												</ul>
											</c:forEach>
										</div>				    					
			    					</c:if>
			    					<%-- 드롭다운에서 파일 선택시 출력 --%>
			    					<c:if test="${filmform.cashFileNo != null}">
				    					<table class="table table-striped table-bordered">
		       					    		<thead class="table-dark">
							    				<tr>
							    					<th>Category</th>
							    					<th>Content</th>
						    					</tr>
					    					</thead>
					    					<c:forEach var="f" items="${fileList}">
						    					<tr>
						    						<td rowspan="2">
						    							<img src="${pageContext.request.contextPath}/upload/${f.filName}.${f.ext}">
						    						</td>
						    					</tr>
									    		<tr>
									    			<td>OriginName</td>
													<td>${f.originName}</td>					    			
								    			</tr>
									    		<tr>
									    			<td>FileName.ext</td>
													<td>${f.fileName}.${f.ext}</td>					    			
								    			</tr>
									    		<tr>
									    			<td>ContentType</td>
													<td>${f.contentType}</td>					    			
								    			</tr>
									    		<tr>
									    			<td>Size</td>
													<td>${f.size}</td>					    			
								    			</tr>
									    		<tr>
									    			<td>CreateDate</td>
													<td>${f.createDate}</td>					    			
								    			</tr>
							    			</c:forEach>
					    				</table>
				    				</c:if>
			    				</c:if>
			    			</div>
			    			
			    			
		    			</div>
  	            </c:if>
  	            
			  </main>
			
			
			
		  <footer class="footer">
			  <c:import url="/WEB-INF/views/inc/footer.jsp"></c:import>
		  </footer>
		</div>
    </body>
</html>