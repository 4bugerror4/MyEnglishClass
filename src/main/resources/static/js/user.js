let userIndex = {
	init: function() {
		$('#user-save').on('click', () => {
			this.userSave();
		});
		
		$('#user-modify').on('click', () => {
			this.userModify();
		});
		
		$('#user-delete').on('click', () => {
			this.userDelete();
		})
	},
	
	userSave: function() {
		let data = {
			username: $('#username').val(),
			password: $('#password').val(),
			email: $('#email').val()
			
		};
		
		$.ajax({
			type: 'POST',
			url: '/auth/api/user/join',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
		}).done(function(resp) {
			if (resp.data == 200) {
				console.log(resp);
				alert('회원 가입 완료');
				location.href='/';
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error.responseText));
			location.href='/auth/user/join';
		})
	},
	
	userModify: function() {
		let data = {
			username: $('#username').val(),
			password: $('#password').val(),
			email: $('#email').val()
			
		};
		
		$.ajax({
			type: 'PUT',
			url: '/auth/api/user/modify',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
		}).done(function(resp) {
			if (resp.data == 200) {
				console.log(resp);
				alert('회원 수정 완료');
				location.href='/';
			} else {
				console.log(resp);
				alert('회원 수정 실패');
				location.href='/auth/user/join';
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})
	},
	
	userDelete: function() {
		let data = {
			id: $('#id').val()
			
		};
		
		$.ajax({
			type: 'DELETE',
			url: '/auth/api/user/delete',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
		}).done(function(resp) {
			if (resp.data == 200) {
				console.log(resp);
				alert('회원 탈퇴 완료');
				location.href='/';
			} else {
				console.log(resp);
				alert('회원 탈퇴 실패');
				location.href='/user/info';
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})
	}
	
}


userIndex.init();