// JavaScript Document
var grid_data = [{
	id: "1",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "2",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "3",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "4",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "5",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "6",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "7",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "8",
	department: "Server",
	address: "note2",
	admin_account: "Yes",
	admin_name: "TNT",
	phone: "2007-12-03"
}, {
	id: "9",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "10",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "11",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "12",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}, {
	id: "13",
	name:"小明",
	department: "市委",
	sex:"男",
	account: "ldk",
	phone: "0523-12345678",
	status:"启用"
}];

jQuery(function ($) {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({
		//direction: "rtl",

		data: grid_data,
		datatype: "local",
		height: 250,
		colNames: [ 'ID', '姓名','保健单位', '性别', '联系电话', '账号', '密码','状态','操作'],
		colModel: [ {
			name: 'id',
			index: 'id',
			width: 60,
			sorttype: "int"
		}, {
			name: 'name',
			index: 'name',
			width: 90,
			editable: true,
		}, {
			name: 'department',
			index: 'department',
			width: 90,
			editable:true,
			edittype:"select",
			editoptions:{value:"1:市委;2:林业局"}
		}, {
			name: 'sex',
			index: 'sex',
			width: 150,
			editable:true,
			edittype:"select",
			editoptions:{value:"1:男;2:女"}
		}, {
			name: 'phone',
			index: 'phone',
			width: 150,
			sortable: false,
			editable: true
		}, {
			name: 'account',
			index: 'account',
			width: 70,
			editable: true
		},{
			name:'password',
			index:'password',
			width:80,
			editable:true,
			hidden:true,
			edittype:'password',
            editrules:{
                         required:true, 
                         edithidden:true
                      }
		}, {
			name: 'status',
			index: 'status',
			width:70, editable: true,edittype:"select",editoptions:{value:"1:启用;0:停用"}
		},{
			name: 'myac',
			index: '',
			width: 80,
			fixed: true,
			sortable: false,
			resize: false,
			formatter: 'actions',
			formatoptions: {
				keys: true,

				delOptions: {
					recreateForm: true,
					beforeShowForm: beforeDeleteCallback
				},
				editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
			}
		}],

		viewrecords: true,
		rowNum: 10,
		rowList: [10, 20, 30],
		pager: pager_selector,
		altRows: true,
		//toppager: true,

		multiselect: false,
		//multikey: "ctrlKey",
		multiboxonly: false,

		loadComplete: function () {
			var table = this;
			setTimeout(function () {
				styleCheckbox(table);

				updateActionIcons(table);
				updatePagerIcons(table);
				enableTooltips(table);
			}, 0);
		},

		editurl: $path_base + "/dummy.html", //nothing is saved
		//caption: "jqGrid with inline editing",


		autowidth: true

	});

	//enable search/filter toolbar
	//jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})

	//switch element when editing inline
	function aceSwitch(cellvalue, options, cell) {
		setTimeout(function () {
			$(cell).find('input[type=checkbox]')
				.wrap('<label class="inline" />')
				.addClass('ace ace-switch ace-switch-5')
				.after('<span class="lbl"></span>');
		}, 0);
	}
	//enable datepicker
	function pickDate(cellvalue, options, cell) {
		setTimeout(function () {
			$(cell).find('input[type=text]')
				.datepicker({
					format: 'yyyy-mm-dd',
					autoclose: true
				});
		}, 0);
	}


	//navButtons
	jQuery(grid_selector).jqGrid('navGrid', pager_selector, { //navbar options
		edit: false,
		editicon: 'icon-pencil blue',
		add: true,
		addicon: 'icon-plus-sign purple',
		del: false,
		delicon: 'icon-trash red',
		search: false,
		searchicon: 'icon-search orange',
		refresh: true,
		refreshicon: 'icon-refresh green',
		view: false,
		viewicon: 'icon-zoom-in grey',
	},{
		beforeShowForm: function(form) {
                  // "editmodlist"
                  var dlgDiv = $("#editmodgrid-table");
                  var parentDiv = dlgDiv.parent(); // div#gbox_list
                  var dlgWidth = dlgDiv.width();
                  var parentWidth = parentDiv.width();
                  var dlgHeight = dlgDiv.height();
                  var parentHeight = parentDiv.height();
                  // TODO: change parentWidth and parentHeight in case of the grid
                  //       is larger as the browser window
                  dlgDiv[0].style.top = Math.round((parentHeight-dlgHeight)/2) + "px";
                  dlgDiv[0].style.left = Math.round((parentWidth-dlgWidth)/2) + "px";
              }
	}, {
		//edit record form
		//closeAfterEdit: true,
		recreateForm: true,
		beforeShowForm: function (e) {
			var form = $(e[0]);
			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
			style_edit_form(form);
		}
	}, {
		//new record form
		closeAfterAdd: true,
		recreateForm: true,
		viewPagerButtons: false,
		beforeShowForm: function (e) {
			var form = $(e[0]);
			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
			style_edit_form(form);
		}
	}, {
		//delete record form
		recreateForm: true,
		beforeShowForm: function (e) {
			var form = $(e[0]);
			if (form.data('styled')) return false;

			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
			style_delete_form(form);

			form.data('styled', true);
		},
		onClick: function (e) {
			alert(1);
		}
	}, {
		//search form
		recreateForm: true,
		afterShowSearch: function (e) {
			var form = $(e[0]);
			form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
			style_search_form(form);
		},
		afterRedraw: function () {
			style_search_filters($(this));
		},
		multipleSearch: true,
		/**
		multipleGroup:true,
		showQuery: true
		*/
	}, {
		//view record form
		recreateForm: true,
		beforeShowForm: function (e) {
			var form = $(e[0]);
			form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
		}
	})



	function style_edit_form(form) {
		//enable datepicker on "sdate" field and switches for "stock" field


		//update buttons classes
		var buttons = form.next().find('.EditButton .fm-button');
		buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove(); //ui-icon, s-icon
		buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
		buttons.eq(1).prepend('<i class="icon-remove"></i>')

		buttons = form.next().find('.navButton a');
		buttons.find('.ui-icon').remove();
		buttons.eq(0).append('<i class="icon-chevron-left"></i>');
		buttons.eq(1).append('<i class="icon-chevron-right"></i>');
	}

	function style_delete_form(form) {
		var buttons = form.next().find('.EditButton .fm-button');
		buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove(); //ui-icon, s-icon
		buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
		buttons.eq(1).prepend('<i class="icon-remove"></i>')
	}

	function style_search_filters(form) {
		form.find('.delete-rule').val('X');
		form.find('.add-rule').addClass('btn btn-xs btn-primary');
		form.find('.add-group').addClass('btn btn-xs btn-success');
		form.find('.delete-group').addClass('btn btn-xs btn-danger');
	}

	function style_search_form(form) {
		var dialog = form.closest('.ui-jqdialog');
		var buttons = dialog.find('.EditTable')
		buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
		buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
		buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
	}

	function beforeDeleteCallback(e) {
		var form = $(e[0]);
		if (form.data('styled')) return false;

		form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
		style_delete_form(form);

		form.data('styled', true);
	}

	function beforeEditCallback(e) {
		var form = $(e[0]);
		form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
		style_edit_form(form);
	}



	//it causes some flicker when reloading or navigating grid
	//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
	//or go back to default browser checkbox styles for the grid
	function styleCheckbox(table) {
		/**
					$(table).find('input:checkbox').addClass('ace')
					.wrap('<label />')
					.after('<span class="lbl align-top" />')
			
			
					$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
					.find('input.cbox[type=checkbox]').addClass('ace')
					.wrap('<label />').after('<span class="lbl align-top" />');
				*/
	}


	//unlike navButtons icons, action icons in rows seem to be hard-coded
	//you can change them like this in here if you want
	function updateActionIcons(table) {
		/**
		var replacement = 
		{
			'ui-icon-pencil' : 'icon-pencil blue',
			'ui-icon-trash' : 'icon-trash red',
			'ui-icon-disk' : 'icon-ok green',
			'ui-icon-cancel' : 'icon-remove red'
		};
		$(table).find('.ui-pg-div span.ui-icon').each(function(){
			var icon = $(this);
			var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
			if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
		})
		*/
	}

	//replace icons with FontAwesome icons like above
	function updatePagerIcons(table) {
		var replacement = {
			'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
			'ui-icon-seek-prev': 'icon-angle-left bigger-140',
			'ui-icon-seek-next': 'icon-angle-right bigger-140',
			'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
		};
		$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
			var icon = $(this);
			var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

			if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
		})
	}

	function enableTooltips(table) {
		$('.navtable .ui-pg-button').tooltip({
			container: 'body'
		});
		$(table).find('.ui-pg-div').tooltip({
			container: 'body'
		});
	}

	//var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');


});
