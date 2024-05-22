<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시물 조회</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시물 조회
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                            <!-- /.row -->
                            <div class="row">
                                <div class="col-lg-12">
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" name="title" value='<c:out value="${board.title}"></c:out>' readonly>
                                        </div>
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" name="writer" value='<c:out value="${board.writer}"></c:out>' readonly>
                                        </div>

                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea class="form-control" rows="3" name="content" readonly><c:out value="${board.content}"></c:out></textarea>
                                        </div>

                                        <a href="modify?bno=${board.bno}&pageNum=${criteria.pageNum}&amount=${criteria.amount}"><button type="button" class="btn btn-success">수정</button></a>
                                        <a href="list?bno=${board.bno}&pageNum=${criteria.pageNum}&amount=${criteria.amount}" style="margin-left:10px;"><button type="button" class="btn btn-success">목록보기</button></a>
                                        
                                    <form role="form" id="goodHateForm" action="good" method="post" style="display:inline-block; padding:0; margin-left:90px;">
										<input type="hidden" value="${board.bno}" name="bno">
										<input type="hidden" value="${criteria.pageNum}" name="pageNum">
										<input type="hidden" value="${criteria.amount}" name="amount">
                                        <button type="button" class="btn btn-success" id="good">좋아요</button> (${board.good})
                                        <button type="button" class="btn btn-warning" id="hate" style="margin-left:10px;">싫어요</button> (${board.hate})
                                    </form>
                                    
                                    <br/><br/>
                                    <div id="replyArea">
                                    	<!-- [작성자]리플내용 11:00 <br/>
                                    	[작성자]리플내용 10:00(10:50) <br/>
                                    	[작성자2]리플내용2 5/12 <br/> -->
                                    </div>
                                    <div id="replyPage">
                                    	<!-- 댓글 페이징 내용 -->
                                    </div>
                                    <br/><br/>
                                    리플:<input type="text" id="reply"> 작성자:<input type="text" id="replyer"> <button type="button" id="addReplyBtn">리플작성</button>
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


         <!-- Modal -->
         <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
             <div class="modal-dialog">
                 <div class="modal-content">
                     <div class="modal-header">
                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                         <h4 class="modal-title" id="myModalLabel">댓글 수정</h4>
                     </div>
                     <div class="modal-body">
                         <form role="form" action="#" method="post" id="replyForm">
                             <div class="form-group">
                                 <label>작성자</label>
                                 <input class="form-control" name="replyer" id="replyer" value="replyer">
                             </div>

                             <div class="form-group">
                                 <label>내용</label>
                                 <textarea class="form-control" rows="3" name="reply" id="reply">reply</textarea>
                             </div>

                             <button type="button" class="btn btn-success" id="replyUpdate">댓글수정</button>
                             <input type="hidden" name="rno" id="rno">
                         </form>
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


	<script src="/resources/js/reply.js"></script>
	<script>
	//aaa();
	//bbb();
	//ccc;
	//console.log(replyService);
	//replyService.name(3);
	//replyService.aaa();
	
	/*
	replyService.add( {bno:1, reply:"ajax를 통해서 처리", replyer:"성공인가"},
			function(result){
				console.log("결과값은 ", result);
				console.log("리플등록성공이다."); } , function(){alert("리플등록실패"); } );
	*/
	
	$("#addReplyBtn").on("click", function(e){
		reply = $("#reply").val();
		console.log("작성할 리플 내용 "+reply);
		replyer = $("#replyer").val();
		console.log("리플 작성자 "+replyer);
		var objReply = {bno:${board.bno}, reply:reply, replyer:replyer};
		
		replyService.add(objReply, function(result){
			$("#reply").val(""); //성공시 작성된 리플 지우기
			$("#replyer").val(""); //성공시 작성된 리플작성자 지우기
			alert(result);
			//작성후에 리플목록 갱신
			replyList(); //작성후에 리플목록 갱신
		});
	});
	//여기에서 작성후에 리플목록 갱신 넣으면 비동기 처리되서 동록되기전 목록 불러오기
	</script>
	
	
	<script>
	//리플목록 가져오기
	replyList();
	function replyList(){
		replyService.getList(${board.bno},function(result){
			console.log("replyVO = ", ${replyVO}); //여기에서 replyVO 객체 값이 넘어옴..
			console.log(result);
			//result 가 댓글 	
			var strHtml = "";
			for(var i=0; i<result.length; i++ ){
				console.log(result[i].reply, result[i].replyer);
				strHtml += "<b>"+result[i].replyer+"</b>"
				+"<br/>"
				+"<span style='display:inline-block; width:100%; border-bottom:1px dotted gray; vertical-align:top; padding-top:5px;padding-bottom:5px;'>"
					+"<span id='replyUpdateBtn' rno='"+result[i].rno+"' replyer='"+result[i].replyer+"' reply='"+result[i].reply+"' style='display:inline-block; width:82%; vertical-align:top; border:0px solid gray;'>"
					+"(<a href='#'>"+result[i].reply+"</a>)"
					+"</span>"
					+"<span id='replyDeleteBtn' rno='"+result[i].rno+"' style='display:inline-block; width:4%; vertical-align:top; text-align:center; border:0px solid gray;'>"
					+"[<a href='#'>x</a>]"
					+"</span>"
					+"<span id='replyDate' rno='"+result[i].rno+"' style='display:inline-block; width:12%; vertical-align:top; text-align:right; color:#777; border:0px solid gray;'>"
					+replyService.displayTime(result[i].replyDate)
					+"</span>"
				+"</span>"
				+"<br/>";
			}
			console.log("pageMaker = ", ${pageMaker});
			console.log("cri = ", ${cri});
/*
			//여기에서 Criteria, replyVO객체값을 받은 걸로 페이징 처리하면 될 것 같음...
			console.log("cri = ", ${cri}); //여기에서 cri 객체 값이 넘어옴..
			var pageHtml = "";			
			pageHtml += "<span id='__' rno='"+result[i].rno+"' style='display:inline-block; width:; text-align:center; border:0px solid gray;'>";
			<c:if test="${pageMaker.prev}">
			<a href="get?pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">Prev</a>
			</c:if>
			for(var i=0; i<replyVO.length; i++ ){
				pageHtml += '';
				pageHtml += '';
				<c:if test="${pageMaker.cri.pageNum eq num}">
				<a href="list?pageNum=${num}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}"><b>${num}</b></a>
				</c:if>
				<c:if test="${pageMaker.cri.pageNum != num}">
				<a href="list?pageNum=${num}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">${num}</a>
				</c:if>
			}
			<c:if test="${pageMaker.next}">
			<a href="list?pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">Next</a>
			</c:if>
			pageHtml += "</span>";
*/			
			console.log("html 확인",strHtml);
			$("#replyArea").html(strHtml);
		});
	}
	
	//동적으로 만들어진 태그임으로 이벤트가 걸리지 않는다.!
	//$("#replyDeleteBtn").on("click", function(){
		//console.log(this);
	//});
	//위임이벤트 처리해야한다.(기존에 있는 요소에 이벤트 걸고 이어서 동적으로 만들어진 요소에 걸기)
	$("#replyArea").on("click","#replyDeleteBtn",function(e){
		e.preventDefault();
		console.log(this);
		console.log("jquery 이용 접근 ", $(this).attr('rno'));
		//확인창 열어서 재확인
		if(confirm("진짜 삭제하시겠습니까?")) {
			replyService.remove($(this).attr('rno'), function(result){
				console.log("리플삭제 성공 ", result);
				replyList(); //삭제후에 리플목록 갱신
			});
		}
		
	});

	
	//위임이벤트 처리해야한다.(기존에 있는 요소에 이벤트 걸고 이어서 동적으로 만들어진 요소에 걸기)
	$("#replyArea").on("click","#replyUpdateBtn",function(e){
		var formObj=$("#replyForm"); //댓글수정 폼 Obj
		e.preventDefault();
		console.log(this);
		console.log("jquery 이용 접근 ", $(this).attr('rno'), $(this).attr('replyer'));
		
		$("#myModal").modal("show");
		
		$("#replyForm #rno").val($(this).attr('rno')); //댓글번호 폼값 셋팅
		$("#replyForm #reply").val($(this).attr('reply')); //내용 폼값 셋팅
		$("#replyForm #replyer").val($(this).attr('replyer')); //작성자 폼값 셋팅
		
		var objReply = {};
		console.log("default objReply : ", objReply);
		
		console.log("수정할 댓글 번호는 ", $("#replyForm #rno").val());
		console.log("댓글 내용 ", $(this).attr('reply'));
		console.log("댓글 작성자 ", $(this).attr('replyer'));
		
		$("#replyForm #replyUpdate").on("click", function(){
			//확인창 열어서 재확인
			if(confirm("진짜 수정하시겠습니까?")) {
				objReply = {rno:$("#replyForm #rno").val(), reply:$("#replyForm #reply").val(), replyer:$("#replyForm #replyer").val()};
				replyService.update(objReply, function(result){
					console.log(" : 리플수정 성공: ", result);
					console.log("result objReply : ", objReply);

					$("#replyForm #rno").val(""); //댓글번호 초기값 셋팅
					$("#replyForm #reply").val(""); //내용 초기값 셋팅
					$("#replyForm #replyer").val(""); //작성자 초기값 셋팅
					$("#myModal").modal("hide");
					
					replyList(); //수정후에 리플목록 갱신
				});
			}
		});
		
	});
	</script>





    <script>
		//[게시글] 좋아요,싫어요 버튼을 누르면
		// remove 로 글번호를 주면서 post요청하기
		$(document).ready(function(){   //문서가 로딩이 완료후에 실행하시오
			var formObj=$("#goodHateForm"); //좋아요,싫어요 폼 Obj
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

<script>
$(document).ready(function(){
	//alert('loading');
	console.log("ReplyVO: ", ${replyVO} );
});
</script>

</body>

</html>
