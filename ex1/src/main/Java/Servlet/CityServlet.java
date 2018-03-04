package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.ServletException;

@WebServlet("/update-city")
public class CityServlet extends HttpServlet {
    @Inject
    private CityDao cityDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        City c1 = new City("warsaw", Long.valueOf(5) );
        cityDao.save(c1);

        City c2 = new City("berlin", Long.valueOf(10) );
        cityDao.save(c2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        PrintWriter printWriter = resp.getWriter();

        String city = req.getParameter("city");
        if (city == null || city.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }
        City existingCity = cityDao.findByName(city);
        if (existingCity == null) {
            City c = new City();
            c.setName(city);
            c.setNumberOfVisits(Long.valueOf(1) );
            cityDao.save(c);
            findMost(req,resp);
            printWriter.write(" ____________________________________\n");
            findAll(req, resp);
        } else {
            existingCity.setName(city);
            existingCity.setNumberOfVisits(existingCity.getNumberOfVisits() + 1);
            cityDao.update(existingCity);
            findMost(req,resp);
            printWriter.write(" ____________________________________\n");
            findAll(req, resp);
        }

    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<City> result = cityDao.findAll();

        for (City p : result) {
            resp.getWriter().write(p.toString() + "\n");
        }
    }
    private void findMost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<City> result = cityDao.findMostCkecked();

        for (City p : result) {
            resp.getWriter().write(p.toString() + "\n");
}}}

