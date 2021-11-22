'use strict';

/*画面ロード時の処理 */
jQuery(function($){
	
	/*削除ボタン押したとき */
	$('#deletecompany').click(function(event){
		deleteCompany();
	});
	
});

function deleteCompany(){
	//form の値を取得
	var formData = $('#stockform').serializeArray();
	
	//ajax 通信
	$.ajax({
		type : "DELETE",
		cache : false,
		url : '/main/deletecompany',
		data : formData,
		dataType : 'json',
	}).done(function(data){
		//ajax 成功時
		alert('company deleted');
		window.location.href='/main';
		
	}).fail(function(jqXHR,textStatus,errorThrown){
		//ajax 失敗
		alert('delete failed. See you ');
	}).always(function(){
		
	});
	
}
