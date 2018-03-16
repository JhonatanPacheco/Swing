package com.example2.controller;

import javax.swing.JInternalFrame;

import com.example2.view.LoginInternalFrame;

public class ControllerFactory {
	
	public static void createController(JInternalFrame view) {
		
		
		
		if (view instanceof LoginInternalFrame){
			new LoginInternalFrameController(view);
		}else{
			 new  NoInternalFrameAvalibleController(view);
		}
			
		
		
//		else if (view instanceof AddReaderInternalFrame)
//			new AddReaderInternalFrameController(view, library, undoObject);
//		else if (view instanceof BookAvailbilityInternalFrame)
//			new BookAvailbilityInternalFrameController(view, library, undoObject);
//		else if (view instanceof BorrowBookInternalFrame)
//			new BorrowBookInternalFrameController(view, library, undoObject);
//		else if (view instanceof ReaderAccountBalanceInternalFrame)
//			new ReaderAccountBalanceInternalFrameController(view, library, undoObject);
//		else if (view instanceof RemoveBookInternalFrame)
//			new RemoveBookInternalFrameController(view, library, undoObject);
//		else if (view instanceof RemoveBorrowInternalFrame)
//			new RemoveBorrowInternalFrameController(view, library, undoObject);
//		else if (view instanceof RemoveReaderInternalFrame)
//			new RemoveReaderInternalFrameController(view, library, undoObject);
	}

}
