/**
* 리플에 관련된 처리를 모아놓은 자바스크립트
*/
console.log("실행테스트");

//모듈패턴 구성 - 메서드를 가지는 객체
var quiz1 = (function(){
	function cal(num1, num2) {
		var sum = 0;
		for(var i=num1; i<=num2; i++) {
			sum += i;
		}
		//console.log("모두 더한 수는 ",sum);
		return "모두 더한 수는 "+sum;
	}
	
	function check() {
		console.log("자바스크립트 함수 이해했다.");
	}	

	return {sum:cal, print:check};
})();

