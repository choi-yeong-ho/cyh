<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시물 수정</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시물 수정
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                            <!-- /.row -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <form role="form" action="modify" method="post">
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" name="title" value='<c:out value="${board.title}"></c:out>'>
                                        </div>
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" name="writer"  value='<c:out value="${board.writer}"></c:out>'>
                                        </div>

                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea class="form-control" rows="3" name="content"><c:out value="${board.content}"></c:out></textarea>
                                        </div>
										<input type="hidden" value="${board.bno}" name="bno">
										<input type="hidden" value="${criteria.pageNum}" name="pageNum">
										<input type="hidden" value="${criteria.amount}" name="amount">
                                        <button type="submit" class="btn btn-success">수정하기</button>
                                        <button type="button" class="btn btn-warning" id="delete">삭제하기</button>
                                        
                                        <!--<button type="button" class="btn btn-success" id="good" style="margin-left:100px;">좋아요</button>
                                        <button type="button" class="btn btn-warning" id="hate">싫어요</button>-->
                                    </form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->

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
		//삭제 버튼을 누리면
		// remove 로 글번호를 주면서 post요청하기
		$(document).ready(function(){   //문서가 로딩이 완료후에 실행하시오
			var formObj=$("form");
			$("#delete").on("click",function(e){
				e.preventDefault();  //해당 요소에 걸린 이벤트를 삭제하고
				formObj.attr("action","remove");  //해당 action속성의 값을 remove로 변경
				$("#delete").attr("type","submit");
				formObj.submit(); //submit (폼 전송)
			}); //삭제 버튼 클릭시 실행
			
			$("#good").on("click",function(e){
				e.preventDefault();  //해당 요소에 걸린 이벤트를 삭제하고
				formObj.attr("action","good");  //해당 action속성의 값을 remove로 변경
				$("#good").attr("type","submit");
				formObj.submit(); //submit (폼 전송)
			}); //좋아요 버튼 클릭시 실행
			
			$("#hate").on("click",function(e){
				e.preventDefault();  //해당 요소에 걸린 이벤트를 삭제하고
				formObj.attr("action","hate");  //해당 action속성의 값을 remove로 변경
				$("#hate").attr("type","submit");
				formObj.submit(); //submit (폼 전송)
			}); //싫어요 버튼 클릭시 실행				
		});
    </script>
    
</body>

</html>
