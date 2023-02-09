let wordIndex = {
	init: function() {
		$('#word-save').on('click', () => {
			this.wordSave();
		});
		
	},
	
	wordSave: function() {
		let data = {
			type: $('#type').val(),
			eng: $('#eng').val(),
			meaning: $('#meaning').val()
			
		};
		
		console.log(data);
		
		$.ajax({
			type: 'POST',
			url: '/api/word/add',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
		}).done(function(resp) {
			if (resp.data == 200) {
				console.log(resp);
				alert('단어 추가 완료');
				location.href='/';
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error.responseText));
			location.href='/add';
		})
	}
	
}


wordIndex.init();