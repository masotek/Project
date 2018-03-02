package com.infoshareacademy.jjdd3;

import java.io.IOException;
import java.io.PrintWriter;



        import com.isa.usersengine.dao.UsersRepositoryDao;
        import com.isa.usersengine.dao.UsersRepositoryDaoBean;
        import com.isa.usersengine.domain.User;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

@WebServlet("/update-city")
public class CityServlet extends HttpServlet{
    @Inject
    private CityDao cityDao;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String city = req.getParameter("city");
        if (city == null || city.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }


        private void updateComputer(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
            final Long id = Long.parseLong(req.getParameter("id"));

            final City existingCity = CityDao.findByName(city);
            if (existingCity== null) {
                City c = new City();

                c.setName(city);
                c.setNumberOfVisits(1);
            } else {
                existingComputer.setName(req.getParameter("name"));
                existingComputer.setOperatingSystem(req.getParameter("operatingSystem"));

                computerDao.update(existingComputer);
                LOG.info("Computer object updated: {}", existingComputer);
            }

            // Return all persisted objects
            findAll(req, resp);
        }
        final City c = new City();
        c.setName(req.getParameter("name"));
        c.setOperatingSystem(req.getParameter("operatingSystem"));

        computerDao.save(c);

        @Inject
        private CityDao cityDao;

        City u = new City();

        u.setAge(age);


        UsersRepositoryDao newUser = new UsersRepositoryDaoBean();
        newUser.addUser(u);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<!DOCTYPE html>");
        printWriter.write("<html><body>");
        printWriter.write("id:" + u.getId());
        printWriter.write("name:" + u.getName());
        printWriter.write("age:" + u.getAge());
        printWriter.write("login:" + u.getLogin());
        printWriter.write("password:" + u.getPassword());
        printWriter.write("</body>");
        printWriter.write("</html>");


    }
    }
@WebServlet(urlPatterns = "/computer")
public class ComputerServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(ComputerServlet.class);

    @Inject
    private ComputerDao computerDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        final String action = req.getParameter("action");
        LOG.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }





    private void updateComputer(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        final Long id = Long.parseLong(req.getParameter("id"));
        LOG.info("Updating Computer with id = {}", id);

        final Computer existingComputer = computerDao.findById(id);
        if (existingComputer == null) {
            LOG.info("No Computer found for id = {}, nothing to be updated", id);
        } else {
            existingComputer.setName(req.getParameter("name"));
            existingComputer.setOperatingSystem(req.getParameter("operatingSystem"));

            computerDao.update(existingComputer);
            LOG.info("Computer object updated: {}", existingComputer);
        }

        // Return all persisted objects
        findAll(req, resp);
    }

    private void addComputer(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        final City city = new City();
        c.setName(req.getParameter("name"));
        c.setOperatingSystem(req.getParameter("operatingSystem"));

        computerDao.save(c);
        LOG.info("Saved a new Computer object: {}", c);

        // Return all persisted objects
        findAll(req, resp);
    }



//    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        final List<Computer> result = computerDao.findAll();
//        LOG.info("Found {} objects", result.size());
//        for (Computer p : result) {
//            resp.getWriter().write(p.toString() + "\n");
//        }
//    }
}

