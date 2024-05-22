/**
* 리플에 관련된 처리를 모아놓은 자바스크립트
*/
console.log("리플모듈 실행테스트");

//모듈패턴 구성 - 메서드를 가지는 객체
var replyService = (function(){
	function add(reply, callback, error) {
		console.log("리플 등록");
		//jquery를 이용한 ajax를 통해서 리플등록처리
		$.ajax({
			type: 'post',   //호출 method: get,post,put,delete...
			url: '/replies/new',  //호출할 url
			data: JSON.stringify(reply),  //우리가 보낼 data(여기서는 js객체를 json으로 변환해서)
			contentType: 'application/json; charset=UTF-8',  //우리가 보내는 데이터 타입
			success: function(result, status, xhr){  //성공 즉, 응답코드가 200일 때 수행할 내용
				//console.log("xhr헤더객체", xhr);
				//console.log("문자상태 ", status);
				//console.log("응답결과 바디내용 ", result);  //result 응답 결과
				//console.log("성공");
				if(callback) {
					callback(result); //성공시 result 가지고 수행할 내용
				}
			},
			error: function(xhr, status, err){ //실패시(즉, 200이 아닐 때)수행할 내용
				//console.log("xhr헤더객체", xhr);
				//console.log("문자상태 ", status);
				//console.log("HTTP 에러가 발생했을 경우 해당 인자 사용 가능", err);  //error 응답 결과			
				//console.log("리플 작성 실패");
				if(error) {
					error(err); //실패시 수행할 내용
				}
			}
		});
	}
	
	function getList(bno, callback, error) {
		console.log("게시글 리플 가져오기");
		$.ajax({
			type: 'get',
			url: '/replies/bno/'+bno,
			success: function(result,status,xhr){  //성공즉 응답코드가 200일때
		  		if(callback) {  //콜백함수가 있다면
		  			callback(result); //성공시 result 가지고 수행할 내용
		  		}
		  	},
		  	error:function(xhr, status, err) {   //실패시(즉 200이 아닐때) 수행할 내용
		  		if(error){ //에러 함수가 있다면
		  			error(err); //실패시 수행할 내용
		  		}
		  	}
	    });
	}
	
	function remove(rno, callback, error) {
		console.log("리플 삭제");
		$.ajax({
			type: 'delete',
			url: '/replies/'+rno,
			success: function(result,status,xhr){  //성공즉 응답코드가 200일때
		  		if(callback) {  //콜백함수가 있다면
		  			callback(result); //성공시 result 가지고 수행할 내용
		  		}
		  	},
		  	error:function(xhr, status, err) {   //실패시(즉 200이 아닐때) 수행할 내용
		  		if(error){ //에러 함수가 있다면
		  			error(err); //실패시 수행할 내용
		  		}
		  	}
	    });
	}
	
	function update(reply, callback, error) {
		console.log("리플 reply: ", reply);
		//console.log("리플 reply.rno: ", reply.rno);
		//console.log("리플 reply.replyer: ", reply.replyer);
		//console.log("리플 reply.reply: ", reply.reply);
		console.log("리플 수정...");
		
		$.ajax({
			type: 'put',
			url: '/replies/'+reply.rno,
			data: JSON.stringify(reply),  //우리가 보낼 data(여기서는 js객체를 json으로 변환해서)
			contentType: 'application/json; charset=UTF-8',  //우리가 보내는 데이터 타입			
			success: function(result,status,xhr){  //성공즉 응답코드가 200일때
		  		if(callback) {  //콜백함수가 있다면
		  			callback(result); //성공시 result 가지고 수행할 내용
		  		}
		  	},
		  	error:function(xhr, status, err) {   //실패시(즉 200이 아닐때) 수행할 내용
		  		if(error){ //에러 함수가 있다면
		  			error(err); //실패시 수행할 내용
		  		}
		  	}
	    });
	}



	//console.log("날짜 포맷 설정");
	//날짜 포맷 설정 메소드
	function displayTime(timeValue) {
		var today = new Date();
		var dateObj = new Date(timeValue);
		var gap = today.getTime() - dateObj.getTime();
		var str = "";

		//console.log("timeValue : ", timeValue);
		//console.log("dateObj : ", dateObj);
		//console.log("gap : ", gap);
		//console.log("(1000*60*60*24) : ", (1000*60*60*24));
		
		if(gap < (1000*60*60*24)) {
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			return [(hh>9 ? '':'0') + hh, ':', (mi>9 ? '':'0') + mi, ':', (ss>9 ? '':'0') + ss].join('');
		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth()+1; //getMonth() is zero-based
			var dd = dateObj.getDate();
			return [yy, '/', (mm>9 ? '':'0') + mm, '/', (dd>9 ? '':'0') + dd].join('');		
		}
	}


	return {add:add, getList:getList, remove:remove, update:update, displayTime:displayTime};
})();







/* 자바스크립트 함수 사용테스트
function aaa() {
	console.log("javaScript에서 aaa 함수");
}

var bbb = function() {
	console.log("이 함수 이름은 bbb");
}

var ccc = (function() {
	console.log("이 함수 이름은 ccc");
})();
*/
