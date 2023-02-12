let wordIndex = {
	init: function() {
		$('#word-save').on('click', () => {
			this.wordSave();
		});
		
		$('#word-modify').on('click', () => {
			this.wordModify();
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
	},
	
	wordModify: function() {
		let data = {
			id: $('#wordId').val(),
			type: $('#type').val(),
			eng: $('#word').val(),
			meaning: $('#meaning').val()
			
		};
		
		console.log(data);
		
		$.ajax({
			type: 'PUT',
			url: '/api/word/modify',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
		}).done(function(resp) {
			if (resp.data == 200) {
				console.log(resp);
				alert('단어 수정 완료');
				location.href='/list/mylist';
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error.responseText));
			location.href='/list/mylist';
		})
	},
	
	wordDelete: function(id) {
		
		console.log(id);
		
		$.ajax({
			type: 'DELETE',
			url: '/api/word/delete/' + id,
			data: JSON.stringify(id),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
		}).done(function(resp) {
			if (resp.data == 200) {
				console.log(resp);
				alert('단어 삭제 완료');
				location.href='/list/mylist';
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error.responseText));
			location.href='/list/mylist';
		})
	}
	
}


wordIndex.init();