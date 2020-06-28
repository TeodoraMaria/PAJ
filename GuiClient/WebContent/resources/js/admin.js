$(document).ready(function() {
	var table = $('#example').DataTable({
		scrollY: 300,
        paging: false
	});
	$('#myInput').on( 'keyup', function () {
	    table.search( this.value ).draw();
	} );
});