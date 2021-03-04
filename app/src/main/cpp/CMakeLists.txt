cmake_minimum_required(VERSION 3.10.2)

project("tempconverter")


add_library(
             temp_lib
             SHARED
             temp_lib.cpp)

find_library(
              log-lib
                log )


target_link_libraries(
                       temp_lib
                        ${log-lib} )