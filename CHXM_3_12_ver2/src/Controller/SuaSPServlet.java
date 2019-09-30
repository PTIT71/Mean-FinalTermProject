package Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Model.*;
import com.java.*;

@WebServlet(name = "SuaSanPham", urlPatterns= { "/SanPham/Sua" })
public class SuaSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO sanPhamDAO;
    public SuaSPServlet() {
    	super();
    }
    private static final String UPLOAD_DIRECTORY = "D:\\Java Code\\CHXM_3_12_ver2\\WebContent\\admin\\dist\\img";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         sanPhamDAO = new SanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
		/*response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		 String tenSP = request.getParameter("tenXe");
         String maSP = request.getParameter("maSP");
         Float giaThanh = Float.parseFloat(request.getParameter("giaThanh"));
         String maLoai = request.getParameter("loaiXe");
         String maTSKT = request.getParameter("maTSKT");
         SanPham sanpham = new SanPham(maSP, tenSP, giaThanh, maLoai, maTSKT);
        try {
			sanPhamDAO.updateSP(sanpham);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url = request.getContextPath() + "/SanPham";
        response.sendRedirect(url);*/
		
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String maxe = "";
 		String tenxe= "";
 		Float giaThanh = 0f ;
 		String maLoai = "";
 		String maKT = "";
 		String hinhAnh = "";
 		

		 if (!ServletFileUpload.isMultipartContent(request)) {
	            // if not, we stop here
	            PrintWriter writer = response.getWriter();
	            writer.println("Error: Form must has enctype=multipart/form-data.");
	            writer.flush();
	            return;
	        }
	        
		 	
	        // configures upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // sets memory threshold - beyond which files are stored in disk 
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // sets temporary location to store files
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

	        ServletFileUpload upload = new ServletFileUpload(factory);

	        // sets maximum size of upload file
	        upload.setFileSizeMax(MAX_FILE_SIZE);

	        // sets maximum size of request (include file + form data)
	        upload.setSizeMax(MAX_REQUEST_SIZE);

	        // constructs the directory path to store upload file
	        // this path is relative to application's directory
	        String uploadPath = UPLOAD_DIRECTORY;
	        
	        try {
	            // parses the request's content to extract file data
	            @SuppressWarnings("unchecked")
	            List<FileItem> formItems = upload.parseRequest(request);

	            if (formItems != null && formItems.size() > 0) {
	                // iterates over form's fields
	                for (FileItem item : formItems) {
	                    // processes only fields that are not form fields
	                	if(item.getFieldName().equals("hinhanh"))
	                	{
	                		
	                		if (!item.isFormField()) {
		                        String fileName = new File(item.getName()).getName();
		                        if(fileName == "")
		                        {
		                        	
		                        }
		                        else {
		                        	hinhAnh = fileName; //lưu tên hình ảnh
			                        String filePath = uploadPath + File.separator + fileName;
			                        File storeFile = new File(filePath);

			                        // saves the file on disk
			                        item.write(storeFile);
			                        request.setAttribute("message",
			                                "Upload has been done successfully >>" + UPLOAD_DIRECTORY + "/" + fileName);
			                        request.setAttribute("images", fileName);
								}
		                        
		                    }		                	
	                	}
	                   else {
	                	   if (item.getFieldName().equals("maSP")) {
	                            maxe = item.getString();
	                            System.out.println(" ma tin la : " + maxe);
	                        }
	                	   if (item.getFieldName().equals("tenXe")) {
	                             tenxe = item.getString();
	                        }
	                	   if (item.getFieldName().equals("giaThanh")) {
	                             giaThanh =Float.parseFloat(item.getString());
	                        }
	                	   if (item.getFieldName().equals("loaiXe")) {
	                             maLoai = item.getString();
	                        }
	                	   if (item.getFieldName().equals("maTSKT")) {
	                             maKT = item.getString();
	                        }
	                	   if (item.getFieldName().equals("hinhtext")) {
	                		   if(hinhAnh== "")
	                		   {
	                             hinhAnh = item.getString();
	                		   }
	                        }
	                   }
	                }
	                SanPham sanPham = new SanPham(maxe ,tenxe, giaThanh, maLoai, maKT, hinhAnh);
	                sanPhamDAO.updateSP(sanPham);
	                String url = request.getContextPath() + "/SanPham";
	    			response.sendRedirect(url);
	            }
	        } catch (Exception ex) {
	            request.setAttribute("message",
	                    "There was an error: " + ex.getMessage());
	        }
	}
}
