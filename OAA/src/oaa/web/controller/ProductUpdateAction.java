package oaa.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import oaa.web.model.ProductBean;

public class ProductUpdateAction extends Action {
	private static final String FALIURE = "success";
	private static final String SUCCESS = "failure";

	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,

			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		ProductBean productBean  = (ProductBean) form;

		FormFile file = productBean.getImage();

		// Get the servers upload directory real path name
		String filePath = getServlet().getServletContext().getRealPath("/") + "upload";
		// create the upload folder if not exists
		File folder = new File(filePath);
		if (!folder.exists()) {
			folder.mkdir();
		}

		//System.out.println(file);
		String fileName = file.getFileName();
		System.out.println(fileName);

		if (!("").equals(fileName)) {

			System.out.println("Server path:" + filePath);
			File newFile = new File(filePath, fileName);

			if (!newFile.exists()) {
				FileOutputStream fos = new FileOutputStream(newFile);
				fos.write(file.getFileData());
				fos.flush();
				fos.close();
			}
			request.setAttribute("uploadedFilePath", newFile.getAbsoluteFile());
			request.setAttribute("uploadedFileName", newFile.getName());
			productBean.setImage(file);
		}
		// TODO Auto-generated method stub
		if (form instanceof ProductBean) {

			ProductBean pb = (ProductBean) form;
			boolean status = false;
			HttpSession session = request.getSession(false);
			String userid = (String) session.getAttribute("user_id");
			int user_id = Integer.parseInt(userid);
			status = pb.updateProduct(user_id);
			System.out.println(status);
			if (status == true) {
				return mapping.findForward(SUCCESS);
			}
		}

		return mapping.findForward(FALIURE);
	}

}
