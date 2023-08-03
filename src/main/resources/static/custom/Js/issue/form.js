$(document).ready(function() {
	console.log("hello");
	var members = [];
	function initMembers() {
		$.get('/rest/member/list', function(data) {
			if( data ) {
				members = data;
				//populateMembersList(data);
		}
		});
	}
	initMembers();
	
		function initBooks() {
		$.get('/rest/book/allbooks', function(data) {
			if( data ) {
				members = data;
				//populateBooksList(data);
			}
		});
	}
	initBooks();
	
	var issues = [];
	function initIssues() {
		$.get('/rest/issue/list', function(data) {
			if( data ) {
				issues = data;
				//populateMembersList(data);
		}
		});
	}
	initIssues();
	
	$('#saveBtn').on('click', function() {
		var id = $(issues.id);
		var name = $(issues.name);
		var memberName = $(issues.memberName);
		
		if( id && name && memberName) {
			var book = { id: id, name: name, memberName: memberName };
			if($('name').present()){
				alert ("The Book is no more available");
			}
		}
	});
	
	function getIssuedBookIds() {
		var ids = [];
		for(var k=0 ; k<booksToIssue.length ; k++) {
			ids.push( booksToIssue[k].id );
		}
		return ids;
	}
	
	function validate() {
		var errors = []
		var member = $('#memberSel').val();
		if( !member ) {
			errors.push('- Select Member');
		}
		if( booksToIssue.length == 0 ) {
			errors.push('- Add Books to issue');
		}
		return errors;
	}
	
});

var booksToIssue = [];

function initBooksInTable() {
	
	var trs = '';
	for( var k=0 ; k<booksToIssue.length ; k++ ) {
		var rowNum = k+1;
		trs += '<tr>';
		trs += '<td>'+rowNum+'</td>';
		trs += '<td>'+booksToIssue[k].tag+'</td>';
		trs += '<td>'+booksToIssue[k].title+'</td>';
		trs += '<td>'+booksToIssue[k].authors+'</td>';
		trs += '<td><a href="javascript:void(0)"  onclick="removeFromTable('+rowNum+', '+booksToIssue[k].id+')"><i class="fa fa-remove"></i></a></td>';
		trs += '</tr>';
	}
	$("#issueBooksTable").find("tr:gt(0)").remove();
	$('#issueBooksTable').append( trs );
}

function removeFromTable(rowNum, id) {
	$('#issueBooksTable tr:eq('+(rowNum)+')').remove();
	removeFromBooksIssuedList(id);
	initBooksInTable();
}

function removeFromBooksIssuedList(id) {
	for( var k=0 ; k<booksToIssue.length ; k++ ) {
		if( booksToIssue[k].id == id ) {
			booksToIssue.splice(k, 1);
			break;
		}
	}
	
function bookvalidate(){
	
}
}