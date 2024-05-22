<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시물 목록</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        	<span style="display:inline-block; width:60%;">등록된 게시글 총 : <b>${pageMaker.total}</b> 개</span>
                       		<span style="display:inline-block; width:38%; text-align:right;"><a href="register"><button type="button" class="btn btn-success">글쓰기</button></a></span>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>글번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                        <th>조회수</th>
                                        <th>좋아요</th>
                                        <th>싫어요</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${list}" var="board">
                                    <tr>
                                        <td><c:out value="${board.bno}"></c:out></td>
                                        <td><a href="get?bno=${board.bno}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}"><c:out value="${board.title}"></c:out></a></td>
                                        <td><c:out value="${board.writer}"></c:out></td>
                                        <td><fmt:formatDate value="${board.regdate}" pattern="yyyy년MM월dd일 E요일 HH:mm"></fmt:formatDate></td>
                                        <td><fmt:formatDate value="${board.updatedate}" pattern="yyyy년MM월dd일 E요일 HH:mm"></fmt:formatDate></td>
                                        <td><c:out value="${board.views}"></c:out></td>
                                        <td><c:out value="${board.good}"></c:out></td>
                                        <td><c:out value="${board.hate}"></c:out></td>
                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            
<%--                             <c:if test="${pageMaker.prev}"><a href="list?pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}">prev</a></c:if> --%>
<%--                             <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num"> --%>
<%--                             	<a href="list?pageNum=${num}&amount=${pageMaker.cri.amount}"> --%>
<%--                             	<c:if test="${pageMaker.cri.pageNum eq num}"><b>${num}</b></c:if> --%>
<%--                             	<c:if test="${pageMaker.cri.pageNum != num}">${num}</c:if> --%>
<!--                             	</a>  -->
<%--                             </c:forEach> --%>
<%--                             <c:if test="${pageMaker.next}"><a href="list?pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}">next</a></c:if> --%>

							<form action="list" method="get">
								<select name="type">
									<option value="T">제목</option>
									<option value="C">내용</option>
									<option value="W">작성자</option>
									<option value="TC">제목 or 내용</option>
									<option value="TW">제목 or 작성자</option>
									<option value="CW">내용 or 작성자</option>
									<option value="TCW">제목 or 내용 or 작성자</option>
								</select>
								<input type="text" name="keyword">
								<input type="submit" value="검색">
							</form>

							<!-- /page-div ~ -->
							<div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
								<ul class="pagination">
									<li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
										<c:if test="${pageMaker.prev}"><a href="list?pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">Prev</a></c:if>
									</li>
					                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
					                	<c:if test="${pageMaker.cri.pageNum eq num}">
									<li class="paginate_button active" aria-controls="dataTables-example" tabindex="0">
					                	<a href="list?pageNum=${num}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}"><b>${num}</b></a>
									</li>
					                	</c:if>
					                	<c:if test="${pageMaker.cri.pageNum != num}">
									<li class="paginate_button" aria-controls="dataTables-example" tabindex="0">
					                	<a href="list?pageNum=${num}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">${num}</a>
									</li>
					                	</c:if>
					                </c:forEach>				
									<li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next">
										<c:if test="${pageMaker.next}"><a href="list?pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">Next</a></c:if>
									</li>
								</ul>
							</div>
							<!-- /.page-div -->

                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->


         <!-- Modal -->
         <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
                 <div class="modal-content">
                     <div class="modal-header">
                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                         <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                     </div>
                     <div class="modal-body">
						글 등록이 실패했습니다
                     </div>
                     <div class="modal-footer">
                         <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                     </div>
                 </div>
                 <!-- /.modal-content -->
             </div>
             <!-- /.modal-dialog -->
         </div>
         <!-- /.modal -->

    </div>
    <!-- /#wrapper -->


    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

	<script>
	var result='${result}';
	console.log("등록된 글번호:",result);
	
	//p257 뒤로가기 이슈 해결
	checkModal(result); //result 값을 넣어서 checkModal 함수를 수행하시오.
	
	//히스토리 상태값을 넣어줌
	history.replaceState({},null,null);
	//history.state 는 히스토리의 상태값 확인 즉, 상태값이 넣어져 있었다면 상태값을 돌려주고
	//아니면(history.replaceState 미사용 시) null
	
	function checkModal(result){
		if(result === '' || history.state) { //글쓰기가 아니라면 아무것도 하지마라(모달창 띄우지마라!)
			return;                          //또는 뒤로가기로 온거면 아무것도 하지마라
		}
		
		if(parseInt(result)>0){ //글쓰기라면 글번호를 보내줌으로
			//$("#myModal").modal("show"); //모달창을 보여줘라
			//보여줘야할 모달창 내용셋팅
			$(".modal-body").html("게시글 "+parseInt(result)+" 번이 등록되었습니다.");
		}
		$("#myModal").modal("show");
	}
	</script>


<%--
다음의 스크립트가 수행되도록 quiz1.js 를 구현하시오.

<script src="/resources/js//quiz1.js?ver1.0"></script>
<script>
	console.log(quiz1.sum(1,10)); //모두 더한 수는 55
	quiz1.print(); //자바스크립트 함수 이해했다.
</script>
--%>


</body>

</html>
