<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">작성자별 게시글 수</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        	<span style="display:inline-block; width:60%;">작성자별 게시글 수</span>
                       		<span style="display:inline-block; width:38%; text-align:right;"><a href="register"><button type="button" class="btn btn-success">글쓰기</button></a></span>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <!-- <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>작성자</th>
                                        <th>게시글 수</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${data}" var="rank">
                                    <tr>
                                        <td><c:out value="${rank.writer}"></c:out></td>
                                        <td><c:out value="${rank.cn}"></c:out></td>
                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>-->
                            
                            <!-- 도넛 그래프 -->
                            <div id="morris-donut-chart"></div>
                            <div id="morris-area-chart" hidden></div>
                            <div id="morris-bar-chart" hidden></div>
                            <div id="morris-line-chart" hidden></div>

                            <!-- /.table-responsive -->
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

    <!-- Morris Charts JavaScript -->
    <!-- 차트 그리기 위한 js -->
    <script src="/resources/vendor/raphael/raphael.min.js"></script>
    <script src="/resources/vendor/morrisjs/morris.min.js"></script>
    <!-- <script src="/resources/data/morris-data.js"></script>-->

	<script>
	$(function() {

	    Morris.Area({
	        element: 'morris-area-chart',
	        data: [{
	            period: '2010 Q1',
	            iphone: 2666,
	            ipad: null,
	            itouch: 2647
	        }, {
	            period: '2010 Q2',
	            iphone: 2778,
	            ipad: 2294,
	            itouch: 2441
	        }, {
	            period: '2010 Q3',
	            iphone: 4912,
	            ipad: 1969,
	            itouch: 2501
	        }, {
	            period: '2010 Q4',
	            iphone: 3767,
	            ipad: 3597,
	            itouch: 5689
	        }, {
	            period: '2011 Q1',
	            iphone: 6810,
	            ipad: 1914,
	            itouch: 2293
	        }, {
	            period: '2011 Q2',
	            iphone: 5670,
	            ipad: 4293,
	            itouch: 1881
	        }, {
	            period: '2011 Q3',
	            iphone: 4820,
	            ipad: 3795,
	            itouch: 1588
	        }, {
	            period: '2011 Q4',
	            iphone: 15073,
	            ipad: 5967,
	            itouch: 5175
	        }, {
	            period: '2012 Q1',
	            iphone: 10687,
	            ipad: 4460,
	            itouch: 2028
	        }, {
	            period: '2012 Q2',
	            iphone: 8432,
	            ipad: 5713,
	            itouch: 1791
	        }],
	        xkey: 'period',
	        ykeys: ['iphone', 'ipad', 'itouch'],
	        labels: ['iPhone', 'iPad', 'iPod Touch'],
	        pointSize: 2,
	        hideHover: 'auto',
	        resize: true
	    });

	    Morris.Donut({
	        element: 'morris-donut-chart',
	        data: [
	        	<c:forEach items="${data}" var="aaa">
	        	{
	            label: "${aaa.writer}",
	            value: ${aaa.cn}
	        	},
	        	</c:forEach>
	        ],
	        resize: true
	    });

	    Morris.Bar({
	        element: 'morris-bar-chart',
	        data: [{
	            y: '2006',
	            a: 100,
	            b: 90
	        }, {
	            y: '2007',
	            a: 75,
	            b: 65
	        }, {
	            y: '2008',
	            a: 50,
	            b: 40
	        }, {
	            y: '2009',
	            a: 75,
	            b: 65
	        }, {
	            y: '2010',
	            a: 50,
	            b: 40
	        }, {
	            y: '2011',
	            a: 75,
	            b: 65
	        }, {
	            y: '2012',
	            a: 100,
	            b: 90
	        }],
	        xkey: 'y',
	        ykeys: ['a', 'b'],
	        labels: ['Series A', 'Series B'],
	        hideHover: 'auto',
	        resize: true
	    });
	    
	});
	</script>

</body>

</html>
