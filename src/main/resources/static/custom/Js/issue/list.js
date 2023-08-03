$(document).ready(function() {
	function initBooks() {
		$.get('/rest/book/allbooks', function(data) {
			if( data ) {
				members = data;
				populateBooksList(data);
			}
		});
	}
	initBooks();
	
	function initMembers() {
		$.get('/rest/member/list', function(data) {
			if( data ) {
				members = data;
				populateMembersList(data);
			}
		});
	}
	initMembers();
	
	function populateMembersList( membersList ) {
		$('#memberSel').empty().append('<td th:text="${i.firstName}"></td>');
		$.each(membersList, function(k, v) {   
		     $('#memberSel').append($("<td></td>")
		                    .attr("value",v.id).text(v.memberName)); 
		});
	}
	
	
	function populateBooksList( booksList ) {
		$('#booksSel').empty().append('<td th:text="${i.name}"></td>');
		$.each(booksList, function(k, v) {   
		     $('#booksSel').append($("<td></td> #memberSel option:selected")
		                    .attr("value",v.id).text(v.name)
		                    /*.attr("data-authors", v.authors)
		                    .attr("data-tag", v.tag)
		                    .attr("data-publisher", v.publisher)*/
		);});
	}
});