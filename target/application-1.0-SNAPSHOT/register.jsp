<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:authentication>
    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
              </div>
                <form class="user" action="${pageContext.request.contextPath}/UserController" method="post">
                    <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                      <input type="text" name="firstName" class="form-control form-control-user" id="firstName" placeholder="First Name">
                  </div>
                  <div class="col-sm-6">
                      <input type="text" name="lastName" class="form-control form-control-user" id="lastName" placeholder="Last Name">
                  </div>
                </div>
                    <div class="form-group row">
                  <div class="col-sm-6">
                      <input type="text" name="mobNo" class="form-control form-control-user" id="mobileNo" placeholder="Mobile No.">
                  </div>
                    <div class="col-sm-6">
                        <input type="text" name="address" class="form-control form-control-user" id="address" placeholder="Address">
                    </div>
                </div>
                    <div class="form-group">
                        <input type="text" name="username" class="form-control form-control-user" id="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control form-control-user" id="email" placeholder="Email Address">
                    </div>
                    <div class="form-group row">
                      <div class="col-sm-6 mb-3 mb-sm-0">
                          <input type="password" name="password" class="form-control form-control-user" id="password" placeholder="Password">
                      </div>
                      <div class="col-sm-6">
                        <input type="password" class="form-control form-control-user" id="repeatPassword" placeholder="Repeat Password">
                      </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-user btn-block">
                      Register Account
                    </button>
                    <hr>
                    <a href="index.html" class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> Register with Google
                    </a>
                    <a href="index.html" class="btn btn-facebook btn-user btn-block">
                      <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                    </a>
                </form>
                <hr>
                <div class="text-center">
                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                </div>
                <div class="text-center">
                  <a class="small" href="login.jsp">Already have an account? Login!</a>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</t:authentication>
